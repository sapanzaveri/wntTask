package com.wmt.sapan.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchDetailResponse {
    @SerializedName("results")
    List<DetailsResponse> detailsResponseList;

    public FetchDetailResponse(List<DetailsResponse> detailsResponseList) {
        this.detailsResponseList = detailsResponseList;
    }

    public List<DetailsResponse> getDetailsResponseList() {
        return detailsResponseList;
    }

    public void setDetailsResponseList(List<DetailsResponse> detailsResponseList) {
        this.detailsResponseList = detailsResponseList;
    }
}
