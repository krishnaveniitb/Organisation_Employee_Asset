package com.Siemens.Service;

import com.Siemens.Model.Asset;
import com.Siemens.Model.Employee;
import com.Siemens.Model.Organization;

import java.util.List;

public interface AssetService {
    public Asset addAsset(Asset organization);

    public List<Asset> getAllAssetList();

    public Asset getAssetById(Long id);

    public List<Asset> getAssetListByOrgId(Long id);

    Asset updateAsset(Asset asset);

    String deleteAsset(Long asset_id);
}
