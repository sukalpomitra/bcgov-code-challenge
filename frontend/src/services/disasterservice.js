import instance from "api/apiClient";
import UrlBuilder from "api/urlParamsBuilder";

import { DISASTERS } from "api/apiEndpoints";

export async function getAllDisasters(queryParams) {
    const urlBuilder = UrlBuilder();
    const baseBuilder = urlBuilder.setUrl(DISASTERS.GET_DISASTERS);
    if (queryParams) {
        baseBuilder.setQueryParams(queryParams);
    }
    const url = baseBuilder
    .build();
    return instance.get(url);
}

export async function updateDisaster(disasterId, disaster) {
    const urlBuilder = UrlBuilder();
    const url = urlBuilder
    .setPathParams({disasterId})
    .setUrl(DISASTERS.UPDATE_DISASTERS).build();
    return instance.put(url, disaster);
}

export async function getEligibleVolunteers(disasterId) {
  const urlBuilder = UrlBuilder();
  const url = urlBuilder
  .setPathParams({disasterId})
  .setUrl(DISASTERS.GET_DISASTER_VOLUNTEERS).build();
  return instance.get(url);
}
