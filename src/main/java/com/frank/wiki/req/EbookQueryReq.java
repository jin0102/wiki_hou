package com.frank.wiki.req;

/**
 * 假设用户可能会把id 和名字作为查询条件
 * 当然真实情况下可能远远不止两个
 */
public class EbookQueryReq extends PageReq {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EbookReq{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
