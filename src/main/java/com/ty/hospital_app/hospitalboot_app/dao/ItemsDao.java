package com.ty.hospital_app.hospitalboot_app.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.hospital_app.hospitalboot_app.dto.Items;
import com.ty.hospital_app.hospitalboot_app.repository.ItemsRepository;

@Repository
public class ItemsDao {
	@Autowired
	ItemsRepository itemrepository;

	public Items saveItems(Items items) {
		return itemrepository.save(items);
	}

	public Items updateItems(Items items) {
		return itemrepository.save(items);
	}

	public Items finditemsById(int id) {
		Optional<Items> optional = itemrepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public String deleteItemsById(int id) {
		itemrepository.deleteById(id);
		return "deleted item id" + id;
	}
}
