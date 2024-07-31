package com.thahawuru_wallet.application.controller;

import com.thahawuru_wallet.application.dto.response.APIResponseDTO;
import com.thahawuru_wallet.application.dto.response.AdminResponseDTO;
import com.thahawuru_wallet.application.dto.response.ApiResponse;
import com.thahawuru_wallet.application.dto.response.MaintainerResponseDTO;
import com.thahawuru_wallet.application.entity.Maintainer;
import com.thahawuru_wallet.application.service.AdminService;
import com.thahawuru_wallet.application.service.ApiService;
import com.thahawuru_wallet.application.service.MaintainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ApiService apiService;

    @PostMapping
    public ResponseEntity<ApiResponse<MaintainerResponseDTO>> createMaintainer(@RequestBody Maintainer maintainer){
        ApiResponse<MaintainerResponseDTO> response = new ApiResponse<>(HttpStatus.CREATED.value(),adminService.createMaintainer(maintainer),"created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

//    @GetMapping("/{maintainerid}")
//    public ResponseEntity<ApiResponse<MaintainerResponseDTO>> getMaintainer(@PathVariable UUID maintainerid){
//        MaintainerResponseDTO maintainer = adminService.getMaintainer(maintainerid);
//        ApiResponse<MaintainerResponseDTO> response = new ApiResponse<>(HttpStatus.OK.value(),maintainer,"success");
//        return new ResponseEntity<>(response,HttpStatus.OK);
//    }
//
//    @GetMapping("delete/{maintainerid}")
//    public  ResponseEntity<ApiResponse<MaintainerResponseDTO>> inactiveMaintianer(@PathVariable UUID maintainerid){
//        MaintainerResponseDTO maintainer = adminService.inactiveMaintainer(maintainerid);
//        ApiResponse<MaintainerResponseDTO> response = new ApiResponse<>(HttpStatus.OK.value(),maintainer,"success");
//        return new ResponseEntity<>(response,HttpStatus.OK);
//    }

    @GetMapping("API/all")
    public ResponseEntity<ApiResponse<List<APIResponseDTO>>> viewAllAPIReqeusts() {
        List<APIResponseDTO> apiList = apiService.viewAllAPIReqeusts();
        ApiResponse<List<APIResponseDTO>> response = new ApiResponse<>(HttpStatus.OK.value(),apiList,"success");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("API/pending")
    public ResponseEntity<ApiResponse<List<APIResponseDTO>>> viewPendingAPIReqeusts() {
        List<APIResponseDTO> apiList = apiService.viewPendingAPIReqeusts();
        ApiResponse<List<APIResponseDTO>> response = new ApiResponse<>(HttpStatus.OK.value(),apiList,"success");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("API/active")
    public ResponseEntity<ApiResponse<List<APIResponseDTO>>> viewActiveAPIReqeusts() {
        List<APIResponseDTO> apiList = apiService.viewActiveAPIReqeusts();
        ApiResponse<List<APIResponseDTO>> response = new ApiResponse<>(HttpStatus.OK.value(),apiList,"success");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("API/accept")
    public ResponseEntity<ApiResponse<APIResponseDTO>> acceptRequest(@PathVariable UUID apiId){
        APIResponseDTO api = apiService.acceptRequest(apiId);
        ApiResponse<APIResponseDTO> response = new ApiResponse<>(HttpStatus.OK.value(),api,"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("API/declined")
    public ResponseEntity<ApiResponse<APIResponseDTO>> declineRequest(@PathVariable UUID apiId){
        APIResponseDTO api = apiService.declineRequest(apiId);
        ApiResponse<APIResponseDTO> response = new ApiResponse<>(HttpStatus.OK.value(),api,"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}

