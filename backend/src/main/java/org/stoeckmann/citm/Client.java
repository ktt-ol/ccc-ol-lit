package org.stoeckmann.citm;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;

import org.stoeckmann.citm.domain.BrowserRepository;
import org.stoeckmann.citm.domain.MachineRepository;
import org.stoeckmann.citm.domain.OperatingSystemRepository;
import org.stoeckmann.citm.domain.entities.Web;
import org.stoeckmann.citm.domain.format.Browser;
import org.stoeckmann.citm.domain.format.Machine;
import org.stoeckmann.citm.domain.format.OperatingSystem;
import org.stoeckmann.citm.domain.format.Spec;

/**
 * Client resource (exposed at "client" path)
 */
@Path("client")
public class Client {
    /**
     * Method handling HTTP GET requests. The returned object will be sent to
     * the client as "application/json" media type.
     *
     * @return Spec object that will be returned as a application/json response.
     * @throws IOException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Spec getIt(@QueryParam("ip") String ip) throws IOException {
        try {
            final EntityManager em = Main.getFactory().createEntityManager();

            final List<Web> webResult = em.createQuery("from Web as web where web.source.ip = '" + ip + "'", Web.class).getResultList();
            final Collection<String> urls = webResult.stream()
                    .filter(web -> isInterestingHost(web.getHost()))
                    .map(web -> web.getHost())
                    .collect(Collectors.toSet());
            final Set<String> userAgents = webResult.stream()
                    .map(web -> web.getAgent())
                    .collect(Collectors.toSet());

            UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();

            final TreeSet<Machine> machines = new TreeSet<>();
            final TreeSet<OperatingSystem> operatingSystems = new TreeSet<>();
            final TreeSet<Browser> browsers = new TreeSet<>();
            int browserVersion = 0;

            for (final String userAgent : userAgents) {
                final ReadableUserAgent agent = parser.parse(userAgent);

                machines.add(MachineRepository.getMachine(agent));
                operatingSystems.add(OperatingSystemRepository.getOperatingSystem(agent));

                Browser browser = BrowserRepository.getBrowser(agent);
                browsers.add(BrowserRepository.getBrowser(agent));
                if (browsers.last().equals(browser)) {
                    browserVersion = getBrowserVersion(agent);
                }
            }

            Machine machine = machines.last();
            OperatingSystem os = operatingSystems.last();
            Browser browser = browsers.last();
            if (machine.equals(Machine.android) && os.equals(OperatingSystem.ios)) {
                machine = Machine.iphone;
            }
            if (machine.equals(Machine.laptop) && os.equals(OperatingSystem.macos)) {
                machine = Machine.macbook;
            }

            Spec spec = new Spec();
            spec.setMachine(machine.ordinal());
            spec.setOs(os.ordinal());
            spec.setBrowser(Arrays.asList(browser.ordinal(), browserVersion));
            spec.setBrowserHistory(urls);
            spec.setAdMap(Collections.emptyMap());
            spec.seteMail("");

            return spec;
        } catch (Exception e) {
            e.printStackTrace();
            return new Spec();
        }
    }

    private int getBrowserVersion(ReadableUserAgent agent) {
        try {
            return Integer.parseInt(agent.getVersionNumber().getMajor());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private boolean isInterestingHost(String host) {
        return host.startsWith("www") || host.split(".").length == 1;
    }
}
