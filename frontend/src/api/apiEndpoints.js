const prefix = "/api/v1";

export const EVENTS = {
  CREATE: `${prefix}/volunteers`, // POST
  GET_SKILLS: `${prefix}/skills`, // GET
  GET_LIMITATIONS: `${prefix}/employee-limitations`, // GET
};

export const DISASTERS = {
  GET_DISASTERS: `${prefix}/disasters`,
  UPDATE_DISASTERS: `${prefix}/disasters/{disasterId}`,
  GET_DISASTER_VOLUNTEERS: `${prefix}/disasters/{disasterId}/volunteers`,
}
