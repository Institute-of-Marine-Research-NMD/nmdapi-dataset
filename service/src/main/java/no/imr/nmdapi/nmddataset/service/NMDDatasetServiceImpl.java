package no.imr.nmdapi.nmddataset.service;

import no.imr.nmdapi.nmddataset.dao.NMDDatasetDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service implementation for biotic queries.
 *
 * @author kjetilf
 */
public class NMDDatasetServiceImpl implements NMDDatasetService {

    @Autowired
    private NMDDatasetDao nmdDatasetDao;

    @Override
    public Object getByMission(final String missiontype, final String year, final String platform, final String delivery) {
        return nmdDatasetDao.getByMission(missiontype, year, platform, delivery);
    }

    @Override
    public boolean hasData(final String missiontype, final String year, final String platform, final String delivery) {
        return nmdDatasetDao.hasData(missiontype, year, platform, delivery);
    }

}
