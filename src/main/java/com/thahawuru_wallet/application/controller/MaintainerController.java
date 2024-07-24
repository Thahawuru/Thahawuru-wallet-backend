package com.thahawuru_wallet.application.controller;

import com.thahawuru_wallet.application.dto.response.ApiResponse;
import com.thahawuru_wallet.application.dto.response.MaintainerResponseDTO;
import com.thahawuru_wallet.application.entity.Maintainer;
import com.thahawuru_wallet.application.service.MaintainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/maintainer")
public class MaintainerController {

    @Autowired
    private MaintainerService maintainerService;

    @PostMapping
    public ResponseEntity<ApiResponse<MaintainerResponseDTO>> createMaintainer(@RequestBody Maintainer maintainer){
        ApiResponse<MaintainerResponseDTO> response = new ApiResponse<>(HttpStatus.CREATED.value(),maintainerService.createMaintainer(maintainer),"created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{maintainerid}")
    public ResponseEntity<ApiResponse<MaintainerResponseDTO>> getMaintainer(@PathVariable UUID maintainerid){
        MaintainerResponseDTO maintainer = maintainerService.getMaintainer(maintainerid);
        ApiResponse<MaintainerResponseDTO> response = new ApiResponse<>(HttpStatus.OK.value(),maintainer,"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("delete/{maintainerid}")
    public  ResponseEntity<ApiResponse<MaintainerResponseDTO>> inactiveMaintianer(@PathVariable UUID maintainerid){
        MaintainerResponseDTO maintainer = maintainerService.inactiveMaintainer(maintainerid);
        ApiResponse<MaintainerResponseDTO> response = new ApiResponse<>(HttpStatus.OK.value(),maintainer,"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
