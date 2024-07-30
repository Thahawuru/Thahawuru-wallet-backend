package com.thahawuru_wallet.application.controller;

import com.thahawuru_wallet.application.dto.response.*;
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
@RequestMapping("/api/v1/admin")
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

    @GetMapping("/{maintainerid}")
    public ResponseEntity<ApiResponse<MaintainerResponseDTO>> getMaintainer(@PathVariable UUID maintainerid){
        MaintainerResponseDTO maintainer = adminService.getMaintainer(maintainerid);
        ApiResponse<MaintainerResponseDTO> response = new ApiResponse<>(HttpStatus.OK.value(),maintainer,"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("delete/{maintainerid}")
    public  ResponseEntity<ApiResponse<MaintainerResponseDTO>> inactiveMaintianer(@PathVariable UUID maintainerid){
        MaintainerResponseDTO maintainer = adminService.inactiveMaintainer(maintainerid);
        ApiResponse<MaintainerResponseDTO> response = new ApiResponse<>(HttpStatus.OK.value(),maintainer,"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("Api/all")
    public ResponseEntity<ApiResponse<List<APIResponseDTO>>> viewAllAPIReqeusts() {
        List<APIResponseDTO> apiList = apiService.viewAllAPIReqeusts();
        ApiResponse<List<APIResponseDTO>> response = new ApiResponse<>(HttpStatus.OK.value(),apiList,"success");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("Api/pending")
    public ResponseEntity<ApiResponse<List<ApiResponseWithStatusDTO>>> viewPendingAPIReqeusts() {
        List<ApiResponseWithStatusDTO> apiList = apiService.viewPendingAPIReqeusts();
        ApiResponse<List<ApiResponseWithStatusDTO>> response = new ApiResponse<>(HttpStatus.OK.value(),apiList,"success");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("Api/active")
    public ResponseEntity<ApiResponse<List<ApiResponseWithStatusDTO>>> viewActiveAPIReqeusts() {
        List<ApiResponseWithStatusDTO> apiList = apiService.viewActiveAPIReqeusts();
        ApiResponse<List<ApiResponseWithStatusDTO>> response = new ApiResponse<>(HttpStatus.OK.value(),apiList,"success");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("Api/accept/{apiId}")
    public ResponseEntity<ApiResponse<List<APIResponseDTO>>> acceptRequest(@PathVariable UUID apiId){
        List<APIResponseDTO> api = apiService.acceptRequest(apiId);
        ApiResponse<List<APIResponseDTO>> response = new ApiResponse<>(HttpStatus.OK.value(),api,"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

//    @GetMapping("Api/active/{apiId}")
//    public ResponseEntity<ApiResponse<List<APIResponseDTO>>> activeRequest(@PathVariable UUID apiId){
//        List<APIResponseDTO> api = apiService.activeRequest(apiId);
//        ApiResponse<List<APIResponseDTO>> response = new ApiResponse<>(HttpStatus.OK.value(),api,"success");
//        return new ResponseEntity<>(response,HttpStatus.OK);
//    }

    @GetMapping("Api/declined/{apiId}")
    public ResponseEntity<ApiResponse<List<APIResponseDTO>>> declineRequest(@PathVariable UUID apiId){
        List<APIResponseDTO> api = apiService.declineRequest(apiId);
        ApiResponse<List<APIResponseDTO>> response = new ApiResponse<>(HttpStatus.OK.value(),api,"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}

