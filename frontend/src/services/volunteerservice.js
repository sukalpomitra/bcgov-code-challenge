import instance from "api/apiClient";
import UrlBuilder from "api/urlParamsBuilder";

import { EVENTS } from "api/apiEndpoints";

/**
 * Create a new event.
 *
 * @param {Object} data - The data for the new event.
 * @returns {Promise} A Promise that resolves when the event is created.
 */
export async function createVolunteer(data) {
  const urlBuilder = UrlBuilder();
  const url = urlBuilder.setUrl(EVENTS.CREATE).build();
  return instance.post(url, data);
}

export async function getAllSkills() {
  const urlBuilder = UrlBuilder();
  const url = urlBuilder.setUrl(EVENTS.GET_SKILLS).build();
  return instance.get(url);
}

export async function getAllLimitations() {
  const urlBuilder = UrlBuilder();
  const url = urlBuilder.setUrl(EVENTS.GET_LIMITATIONS).build();
  return instance.get(url);
}
