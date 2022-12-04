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
import com.ty.hospital_app.hospitalboot_app.dto.MedOrder;
import com.ty.hospital_app.hospitalboot_app.service.MedOrderService;
import com.ty.hospital_app.hospitalboot_app.util.ResponseStructure;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("medorder")
public class MedOrderController {
	@Autowired
	private MedOrderService medOrderService;

	@ApiOperation(value = "save medorder", notes = "method used to save medorder ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"), @ApiResponse(code = 404, message = "notfound"),
			@ApiResponse(code = 302, message = "notfound") })

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody MedOrder medOrder) {
		return medOrderService.saveMedOrder(medOrder);
	}

	@ApiOperation(value = "update medorder", notes = "method used to update medorder by passing existing medorder id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"), @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 302, message = "notfound") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestBody MedOrder medOrder,
			@RequestParam int id) {
		return medOrderService.updateMedOrder(medOrder, id);
	}

	@ApiOperation(value = "delete item by id", notes = "method used to delete medorder by  passing medorder id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"), @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 302, message = "notfound") })

	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(@PathVariable int id) {
		return medOrderService.deleteMedOrder(id);

	}

	@ApiOperation(value = "get medorder by id", notes = "method used to get medorder details by passing medorder id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"), @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 302, message = "notfound") })

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(@RequestParam int id) {
		return medOrderService.getMedorderbyId(id);
	}
}
