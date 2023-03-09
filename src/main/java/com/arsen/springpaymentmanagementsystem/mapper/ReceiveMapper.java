package com.arsen.springpaymentmanagementsystem.mapper;

import com.arsen.springpaymentmanagementsystem.dto.ReceiveDTO;
import com.arsen.springpaymentmanagementsystem.dto.ReturnReceiveDTO;
import com.arsen.springpaymentmanagementsystem.models.Receive;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceiveMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public ReceiveMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ReceiveDTO convertToDTO(Receive receive) {
        return modelMapper.map(receive, ReceiveDTO.class);
    }

    public ReturnReceiveDTO convertToReturnDTO(Receive receive) {
        return modelMapper.map(receive, ReturnReceiveDTO.class);
    }

    public Receive convertToEntity(ReceiveDTO receiveDTO) {
        return modelMapper.map(receiveDTO, Receive.class);
    }
}
