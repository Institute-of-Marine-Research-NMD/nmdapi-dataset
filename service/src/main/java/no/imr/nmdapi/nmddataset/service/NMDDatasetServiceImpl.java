package no.imr.nmdapi.nmddataset.service;

import java.util.List;
import no.imr.nmdapi.dao.file.NMDDatasetDao;
import no.imr.nmdapi.generic.response.v1.ListElementType;
import no.imr.nmdapi.generic.response.v1.ResultElementType;
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
        return nmdDatasetDao.getDatasets(missiontype, year, platform, delivery);
    }

    @Override
    public boolean hasData(final String missiontype, final String year, final String platform, final String delivery) {
        return nmdDatasetDao.getDatasets(missiontype, year, platform, delivery).getDataset().size() > 0;
    }

    @Override
    public ListElementType getList(String... pathvars) {
        ListElementType listElementType = new ListElementType();
        List<String> dirs = nmdDatasetDao.list(pathvars);
        for (String str : dirs) {
            ResultElementType resultElementType = new ResultElementType();
            resultElementType.setResult(str);
            listElementType.getElement().add(resultElementType);
        }
        return listElementType;
    }

}
