package com.carservice.data.mappers;

import com.carservice.data.CarService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CarServiceMapper {

    @Select("select * from car_service")
    List<CarService> getAll();
}
