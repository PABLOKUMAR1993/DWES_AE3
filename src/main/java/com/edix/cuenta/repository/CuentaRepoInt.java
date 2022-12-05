package com.edix.cuenta.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.cuenta.modelo.beans.Cuenta;


public interface CuentaRepoInt extends JpaRepository<Cuenta, Integer>{}
