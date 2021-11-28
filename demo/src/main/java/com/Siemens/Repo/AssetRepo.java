package com.Siemens.Repo;

import com.Siemens.Model.Asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AssetRepo extends CrudRepository<Asset,Long> {
}
