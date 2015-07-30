package no.imr.nmdapi.nmddataset.dao;

import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author kjetilf
 */
public class NMDDataDaoImpl implements NMDDataDao {

    /**
     * Class logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(NMDDataDaoImpl.class);

    @Override
    public <T> T getFile(final Class<T> classes, final File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(classes.getPackage().getName());
            Unmarshaller jaxbMarshaller = context.createUnmarshaller();
            Object response = jaxbMarshaller.unmarshal(file);
            if (response instanceof JAXBElement) {
                return (T) ((JAXBElement) response).getValue();
            } else {
                return (T) response;
            }
        } catch (JAXBException ex) {
            LOG.error("Error unmarshalling. ", ex);
        }
        return null; // TODO add throws if unmarshall fails.
    }

    @Override
    public Object getFile(final String packageName, final File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(packageName);
            Unmarshaller jaxbMarshaller = context.createUnmarshaller();
            Object response = jaxbMarshaller.unmarshal(file);
            if (response instanceof JAXBElement) {
                return ((JAXBElement) response).getValue();
            } else {
                return response;
            }
        } catch (JAXBException ex) {
            LOG.error("Error unmarshalling. ", ex);
        }
        return null; // TODO add throws if unmarshall fails.
    }

}
