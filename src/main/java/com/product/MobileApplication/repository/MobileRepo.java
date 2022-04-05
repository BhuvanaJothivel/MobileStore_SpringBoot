package com.product.MobileApplication.repository;

import org.springframework.stereotype.Repository;

import com.product.MobileApplication.model.Mobile;

import org.springframework.data.jpa.repository.*;

@Repository
public interface MobileRepo extends JpaRepository<Mobile,Integer> {
}