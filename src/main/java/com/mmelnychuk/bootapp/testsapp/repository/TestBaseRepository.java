package com.mmelnychuk.bootapp.testsapp.repository;

import com.mmelnychuk.bootapp.testsapp.model.TestBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestBaseRepository extends JpaRepository<TestBase, Integer> {

    @Query("SELECT testbase FROM TestBase testbase WHERE testbase.owner.id = :ownerId")
    List<TestBase> findAllByOwnerId(@Param("ownerId") Integer ownerId);

    @Query("SELECT testbase FROM TestBase testbase WHERE testbase.name = :testBaseName")
    Optional<TestBase> getTestBaseByName(@Param("testBaseName") String testBaseName);

}