package com.Siemens.Service.impl;

import com.Siemens.Exception.NoValueFoundException;
import com.Siemens.Model.Asset;
import com.Siemens.Model.Organization;
import com.Siemens.Repo.AssetRepo;
import com.Siemens.Repo.EmployeeRepo;
import com.Siemens.Repo.OrganizationRepo;
import com.Siemens.Service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssetServiceImpl implements AssetService {
    @Autowired
    private OrganizationRepo organizationRepo;

    @Autowired
    private AssetRepo assetRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Asset addAsset(Asset asset) {
        return assetRepo.save(asset);
    }

    @Override
    public List<Asset> getAllAssetList() {
        List<Asset> assetList = new ArrayList<>();
        assetRepo.findAll().forEach(assetList::add);
        return assetList;
    }

    @Override
    public Asset getAssetById(Long id) {
        Optional<Asset> asset = assetRepo.findById(id);
        if(asset.isPresent()){
            return asset.get();
        }
        else {
            throw new NoValueFoundException("No Asset found for this id! Try again with some other Id");
        }
    }

    @Override
    public List<Asset> getAssetListByOrgId(Long id) {
        Organization org = organizationRepo.findById(id).get();
        if(org==null){
            throw new NoValueFoundException("No Asset found for this id! Try again with some other Id");
        }
        return org.getAssetList();
    }

    @Override
    public Asset updateAsset(Asset asset) {
        return assetRepo.save(asset);
    }

    @Override
    public String deleteAsset(Long asset_id) {
        assetRepo.deleteById(asset_id);
        return "Deleted successfully";
    }
}
