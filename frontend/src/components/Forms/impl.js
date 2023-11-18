export const buildForm = (skills = [], limitations = []) => {
  const volunteerForm = {
    title: "chef",
    type: "form",
    name: "chef",
    path: "chef",
    display: "form",
    tags: [],
    settings: {},
    components: [
      {
        label: "Personal Details Column Wrapper",
        key: "personalDetailsColumnWrapper",
        type: "columns",
        customClass: "block-one",
        columns: [
          {
            components: [
              {
                label: "Personal Details",
                tag: "h4",
                attrs: [
                  {
                    attr: "",
                    value: "",
                  },
                ],
                content: "Personal Details",
                refreshOnChange: false,
                key: "personalDetails",
                type: "htmlelement",
                input: false,
                tableView: false,
                customClass: "title_label",
              },
              {
                label: "personal-details-col",
                columns: [
                  {
                    components: [
                      {
                        label: "First Name",
                        placeholder: "John",
                        applyMaskOn: "change",
                        tableView: true,
                        validate: {
                          required: true,
                        },
                        key: "firstName",
                        type: "textfield",
                        input: true,
                      },
                      {
                        label: "Phone Number",
                        applyMaskOn: "change",
                        tableView: true,
                        validate: {
                          required: true,
                        },
                        key: "phoneNumber",
                        type: "phoneNumber",
                        input: true,
                      },
                      {
                        label: "Date of Birth",
                        placeholder: "dd/mm/yy",
                        widget: {
                          type: "calendar",
                          altInput: true,
                          allowInput: true,
                          clickOpens: true,
                          enableDate: true,
                          enableTime: false,
                          mode: "single",
                          noCalendar: false,
                          format: "yyyy-MM-dd hh:mm a",
                          dateFormat: "yyyy-MM-ddTHH:mm:ssZ",
                          useLocaleSettings: false,
                          hourIncrement: 1,
                          minuteIncrement: 5,
                          time_24hr: false,
                          saveAs: "text",
                          displayInTimezone: "viewer",
                          locale: "en",
                        },
                        applyMaskOn: "change",
                        tableView: true,
                        validate: {
                          required: true,
                        },
                        key: "dateOfBirth",
                        type: "textfield",
                        input: true,
                      },
                    ],
                    width: 6,
                    offset: 0,
                    push: 0,
                    pull: 0,
                    size: "md",
                    currentWidth: 6,
                  },
                  {
                    components: [
                      {
                        label: "Last Name",
                        placeholder: "Doe",
                        applyMaskOn: "change",
                        tableView: true,
                        case: "mixed",
                        validate: {
                          required: true,
                        },
                        key: "lastName",
                        type: "textfield",
                        input: true,
                      },
                      {
                        label: "Email",
                        applyMaskOn: "change",
                        tableView: true,
                        validate: {
                          required: true,
                        },
                        key: "email",
                        type: "email",
                        placeholder: "johndoe@xyz.com",
                        input: true,
                      },
                      {
                        label: "Gender",
                        widget: "choicesjs",
                        placeholder: "Select the Gender",
                        tableView: true,
                        data: {
                          values: [
                            {
                              label: "Male",
                              value: "MALE",
                            },
                            {
                              label: "Female",
                              value: "FEMALE",
                            },
                            {
                              label: "Prefer Not to Say",
                              value: "OTHER",
                            },
                          ],
                        },
                        validate: {
                          onlyAvailableItems: true,
                        },
                        key: "gender",
                        type: "select",
                        input: true,
                      },
                    ],
                    width: 6,
                    offset: 0,
                    push: 0,
                    pull: 0,
                    size: "md",
                    currentWidth: 6,
                  },
                ],
                customClass: "personal-details-col",
                key: "personalDetailsCol",
                type: "columns",
                input: false,
                tableView: false,
              },
            ],
            width: 12,
            offset: 0,
            push: 0,
            pull: 0,
            size: "md",
            currentWidth: 12,
          },
        ],
      },
      {
        label: "Volunteer Profile Column Wrapper",
        key: "volunteerProfileColumnWrapper",
        type: "columns",
        customClass: "block-two",
        columns: [
          {
            components: [
              {
                label: "Volunteer Profile Details",
                tag: "h4",
                attrs: [
                  {
                    attr: "",
                    value: "",
                  },
                ],
                content: "Volunteer Profile Details",
                refreshOnChange: false,
                key: "personalDetails1",
                type: "htmlelement",
                input: false,
                tableView: false,
                customClass: "title_label",
              },
              {
                label: "volunteer-details",
                columns: [
                  {
                    components: [
                      {
                        label: "How many years of Volunteer experience do you have ?",
                        widget: "choicesjs",
                        placeholder: "Enter your years of experience",
                        tableView: false,
                        delimiter:false,
                        requireDecimal:false,
                        inputFormat:"plain",
                        truncateMultipleSpaces:false,
                        key: "yearsOfExperience",
                        type: "number",
                        input: true,
                      },
                      {
                        label: "Do you have own transportation ?",
                        tag: "h5",
                        attrs: [
                          {
                            attr: "",
                            value: "",
                          },
                        ],
                        content: "Do you have own transportation ?",
                        refreshOnChange: false,
                        key: "personalDetails3",
                        type: "htmlelement",
                        input: false,
                        tableView: false,
                        customClass: "transportation_label",
                      },
                      {
                        optionsLabelPosition: "right",
                        inline: true,
                        tableView: false,
                        hideLabel: true,
                        // defaultValue: false,
                        values: [
                          {
                            label: "Yes",
                            value: true,
                            shortcut: "",
                          },
                          {
                            label: "No",
                            value: false,
                            shortcut: "",
                          },
                        ],
                        key: "doYouHaveOwnTransportation",
                        type: "radio",
                        input: true,
                      },
                      {
                        label: "Your availability ?",
                        tag: "h5",
                        attrs: [
                          {
                            attr: "",
                            value: "",
                          },
                        ],
                        content: "Your availability ?",
                        refreshOnChange: false,
                        key: "personalDetails3",
                        type: "htmlelement",
                        input: false,
                        tableView: false,
                        customClass: "transportation_label",
                      },
                      {
                        optionsLabelPosition: "right",
                        inline: true,
                        tableView: false,
                        hideLabel: true,
                        values: [
                          {
                            label: "Immediate availability ",
                            value: "IMMEDIATE",
                            shortcut: "",
                          },
                          {
                            label: "Custom availability",
                            value: "CUSTOM",
                            shortcut: "",
                          },
                        ],
                        key: "availability",
                        type: "radio",
                        input: true,
                      },
                      {
                        label: "Select your availability ?",
                        widget: "choicesjs",
                        tableView: true,
                        multiple: true,
                        customClass: "special_components",
                        data: {
                          values: [
                            {
                              label: "Sunday",
                              value: "SUNDAY",
                            },
                            {
                              label: "Monday",
                              value: "MONDAY",
                            },
                            {
                              label: "Tuesday",
                              value: "TUESDAY",
                            },
                            {
                              label: "Wednesday",
                              value: "WEDNESDAY",
                            },
                            {
                              label: "Thursday",
                              value: "THURSDAY",
                            },
                            {
                              label: "Friday",
                              value: "FRIDAY",
                            },
                            {
                              label: "Saturday",
                              value: "SATURDAY",
                            },
                          ],
                        },
                        key: "selectAvailability",
                        conditional: {
                          show: true,
                          conjunction: "all",
                          conditions: [
                            {
                              component: "availability",
                              operator: "isEqual",
                              value: "CUSTOM",
                            },
                          ],
                        },
                        type: "select",
                        input: true,
                      },
                    ],
                    width: 6,
                    offset: 0,
                    push: 0,
                    pull: 0,
                    size: "md",
                    currentWidth: 6,
                  },
                  {
                    components: [
                      {
                        label: "Emergency Contact Number",
                        applyMaskOn: "change",
                        tableView: true,
                        key: "emergencyNumber",
                        type: "phoneNumber",
                        input: true,
                      },
                    ],
                    width: 6,
                    offset: 0,
                    push: 0,
                    pull: 0,
                    size: "md",
                    currentWidth: 6,
                  },
                ],
                customClass: "volunteer-details-col",
                key: "volunteerDetails",
                type: "columns",
                input: false,
                tableView: false,
              },
              {
                label: "Skills and abilities",
                tag: "h5",
                attrs: [
                  {
                    attr: "",
                    value: "",
                  },
                ],
                content: "Skills and Abilities",
                refreshOnChange: false,
                key: "personalDetails2",
                type: "htmlelement",
                input: false,
                tableView: false,
                customClass: "skills_ability_label",
              },
              ...buildSkillsSection(skills),
              {
                label: "Limitations or Constrains",
                tag: "h5",
                attrs: [
                  {
                    attr: "",
                    value: "",
                  },
                ],
                content: "Limitations or Constrains",
                refreshOnChange: false,
                key: "personalDetails3",
                type: "htmlelement",
                input: false,
                tableView: false,
                customClass: "skills_ability_label",
              },
              {
                optionsLabelPosition: "right",
                inline: true,
                hideLabel: true,
                tableView: false,
                customClass: "title_label",
                values: [
                  {
                    label: "No Limitation",
                    value: "NO",
                    shortcut: "",
                  },
                  {
                    label: "Select Your Limitation",
                    value: "CUSTOM",
                    shortcut: "",
                  },
                ],
                key: "limitations",
                type: "radio",
                input: true,
              },
              {
                label: "Columns",
                columns: [
                  {
                    components: [
                      {
                        label: "What are your limitations ?",
                        widget: "choicesjs",
                        tableView: true,
                        multiple: true,
                        customClass: "title_label",
                        data: {
                          values: limitations,
                        },
                        key: "limitationArr",
                        conditional: {
                          show: true,
                          conjunction: "all",
                          conditions: [
                            {
                              component: "limitations",
                              operator: "isEqual",
                              value: "CUSTOM",
                            },
                          ],
                        },
                        type: "select",
                        input: true,
                      },
                    ],
                    width: 6,
                    offset: 0,
                    push: 0,
                    pull: 0,
                    size: "md",
                    currentWidth: 6,
                  },
                  {
                    components: [],
                    width: 6,
                    offset: 0,
                    push: 0,
                    pull: 0,
                    size: "md",
                    currentWidth: 6,
                  },
                ],
                key: "columns1",
                type: "columns",
                input: false,
                tableView: false,
              },
            ],
            width: 12,
            offset: 0,
            push: 0,
            pull: 0,
            size: "md",
            currentWidth: 12,
          },
        ],
      },

      {
        label: "Columns",
        customClass: "button-col",
        columns: [
          {
            components: [
              {
                label: "Submit",
                showValidations: false,
                theme: "success",
                block: true,
                tableView: false,
                key: "submit",
                type: "button",
                saveOnEnter: false,
                input: true,
                customClass: "submit_btn",
              },
            ],
            width: 4,
            offset: 0,
            push: 0,
            pull: 0,
            size: "sm",
            currentWidth: 4,
          },
          {
            components: [
              {
                label: "Reset",
                action: "reset",
                showValidations: false,
                block: true,
                tableView: false,
                key: "reset",
                type: "button",
                input: true,
                customClass: "reset_btn",
              },
            ],
            offset: 0,
            push: 0,
            pull: 0,
            size: "sm",
            currentWidth: 4,
            width: 4,
          },
        ],
        autoAdjust: true,
        key: "columns",
        type: "columns",
        input: false,
        tableView: false,
      },
    ],
  };

  return volunteerForm;
};

// Function to generate the skills and abilities section
const buildSkillsSection = (skills = []) => {
  // Define the common structure for each skill section
  const skillSection = {
    labelPosition: "left-right",
    optionsLabelPosition: "right",
    inline: true,
    tableView: false,
    values: [
      {
        label: "Beginner",
        value: "BEGINNER",
        shortcut: "",
      },
      {
        label: "Intermediate",
        value: "INTERMEDIATE",
        shortcut: "",
      },
      {
        label: "Advanced",
        value: "ADVANCED",
        shortcut: "",
      },
      {
        label: "No Experience",
        value: "NO_EXPERIENCE",
        shortcut: "",
      },
    ],
    type: "radio",
    input: true,
    labelWidth: 10,
    labelMargin: 10,
    customClass: "skills_ability_section",
  };

  // Build and return an array of skill sections based on the provided skills
  return skills.map((skill) => ({
    ...skillSection,
    label: skill.label,
    key: skill.label,
  }));
};
