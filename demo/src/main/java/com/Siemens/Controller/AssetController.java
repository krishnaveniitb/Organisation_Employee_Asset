package com.Siemens.Controller;

import com.Siemens.Model.Asset;
import com.Siemens.Service.AssetService;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssetController {
    @Autowired
    private AssetService assetService;

    @GetMapping("/asset_list/{id}")
    public String getAssetListByOrgId(@PathVariable(name = "id") Long org_id) throws SerializeException {
        XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
        return xmlSerializer.serialize(assetService.getAssetListByOrgId(org_id));
    }
    @PostMapping("/asset/add")
    public String addEmployee(@RequestBody Asset asset) throws SerializeException {
        XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
        return xmlSerializer.serialize(assetService.addAsset(asset));
    }
    @GetMapping("/asset/list-all")
    public String getAllOrganisationList() throws SerializeException {
        XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
        List<Asset> assetList = assetService.getAllAssetList();
        return xmlSerializer.serialize(assetList);
    }
    @PutMapping("/update_assert")
    public Asset updateAsset(@RequestBody Asset asset){
        return assetService.updateAsset(asset);
    }
    @DeleteMapping("/delete_asset/{id}")
    public String deleteAsset(@PathVariable(name = "id") Long asset_id){
        return assetService.deleteAsset(asset_id);
    }

}
