package no.imr.nmdapi.nmddataset.service;

import java.util.List;
import java.util.Map;
import no.imr.nmdapi.generic.response.v1.ListElementType;
import no.imr.nmdapi.generic.response.v1.ResultElementType;
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

    @Override
    public ListElementType getList(String... pathvars) {
        ListElementType listElementType = new ListElementType();
        List<String> dirs = nmdDatasetDao.getDirs(pathvars);
        for (String str : dirs) {
            ResultElementType resultElementType = new ResultElementType();
            resultElementType.setResult(str);
            listElementType.getElement().add(resultElementType);
        }
        return listElementType;
    }

}
