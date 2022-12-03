package com.ty.hospital_app.hospitalboot_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ty.hospital_app.hospitalboot_app.dto.Items;
import com.ty.hospital_app.hospitalboot_app.service.ItemsService;
import com.ty.hospital_app.hospitalboot_app.util.ResponseStructure;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("items")
public class ItemsController {
	@Autowired
	ItemsService itemsService;

	@ApiOperation(value = "save items", notes = "method used to save item ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"), @ApiResponse(code = 404, message = "notfound"),
			@ApiResponse(code = 302, message = "notfound") })

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Items>> saveItems(@RequestBody Items items) {
		return itemsService.saveItems(items);
	}

	@ApiOperation(value = "update item", notes = "method used to update item by passing existing item id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"), @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 302, message = "notfound") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Items>> UpdatItems(@RequestBody Items items, @RequestParam int id) {
		return itemsService.updateItemsById(items, id);
	}

	@ApiOperation(value = "delete item by id", notes = "method used to delete item by  passing item id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"), @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 302, message = "notfound") })

	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteItems(@PathVariable int id) {
		return itemsService.deleteItemById(id);

	}

	@ApiOperation(value = "get item by id", notes = "method used to get item details by passing item id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"), @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 302, message = "notfound") })

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Items>> getItemsById(@RequestParam int id) {
		return itemsService.getitemByid(id);

	}
}
