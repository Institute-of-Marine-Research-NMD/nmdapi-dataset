package no.imr.nmdapi.nmddataset.dao.config;

import no.imr.nmdapi.nmddataset.dao.NMDDataDao;
import no.imr.nmdapi.nmddataset.dao.NMDDataDaoImpl;
import no.imr.nmdapi.nmddataset.dao.NMDDatasetDao;
import no.imr.nmdapi.nmddataset.dao.NMDDatasetDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class is referenced from the application to configure the neccesary
 * beans for spring.
 *
 * @author kjetilf
 */
@Configuration
public class NMDDatasetDaoConfig {

    /**
     * Initalizes the biotic dao as a spring bean.
     * @return  The biotic DAO layer.
     */
    @Bean(name = "nmdDatasetDao")
    public NMDDatasetDao nmdDatasetDao() {
        return new NMDDatasetDaoImpl();
    }

    /**
     * Initalizes the biotic dao as a spring bean.
     * @return  The biotic DAO layer.
     */
    @Bean(name = "nmdDataDao")
    public NMDDataDao nmdDataDao() {
        return new NMDDataDaoImpl();
    }


}
