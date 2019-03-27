package br.eti.webstuff.soap.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.eti.webstuff.soap.crm.bean.CustomerBean;

public interface CustomerDetailRepository extends JpaRepository<CustomerBean, Integer>  {

}
