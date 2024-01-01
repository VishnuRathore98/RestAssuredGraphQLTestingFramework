package com.qa.pojos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GraphQLQuery {

    private String query;
    private Object variables;

}
