export const buildPayload = ({ data }, skillsList) => {
  const payload = {
    firstName: data?.firstName || "",
    lastName: data?.lastName || "",
    phoneNumber: data?.phoneNumber || "",
    dateOfBirth: data?.dateOfBirth || "",
    gender: data?.gender || "",
    email: data?.email || "",
    profile: {
      hasTransportation: data?.doYouHaveOwnTransportation || false,
      yearsOfActivity: data?.yearsOfExperience || "",
      emergencyContactNumber: data?.emergencyNumber || "",
      skills: [],
    },
  };

  if (data?.availability) {
    // payload.profile.availability = {
    //   type: data.availability,
    //   days: data.availability === "CUSTOM" ? data.selectAvailability || [] : [],
    // };

    payload.profile.availabilityType = data.availability;
    payload.profile.availableDays = data.availability === "CUSTOM" ? data.selectAvailability || [] : [];
    // {
    //   type: data.availability,
    //   days: data.availability === "CUSTOM" ? data.selectAvailability || [] : [],
    // };
  }

  skillsList.forEach(({ label, value }) => {
    if (data[label]) {
      payload.profile.skills.push({
        skillCode: value,
        skillLevel: data[label],
      });
    }
  });

  if (data?.limitations) {
    payload.profile.limitation = {
      hasLimitation: data.limitations === "CUSTOM" ? true : false,
      limitationCodes:
        data.limitations === "CUSTOM" ? data.limitationArr || [] : [],
    };
  }

  return payload;
};
