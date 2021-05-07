package com.mmelnychuk.bootapp.testsapp.dto.read;

public class TestBaseTaskOptionDTO {

    private Integer id;
    private String option;

    public TestBaseTaskOptionDTO() {}

    public TestBaseTaskOptionDTO(Integer id, String option) {
        this.id = id;
        this.option = option;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
