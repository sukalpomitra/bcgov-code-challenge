import React, { useEffect, useState } from 'react'
import toast from 'react-simple-toasts';
import { useNavigate } from 'react-router-dom';

import FormComponent from 'components/Forms/VolunteerForm'

import { buildPayload } from './utils';
import { createVolunteer, getAllLimitations, getAllSkills } from 'services/volunteerservice';

function VolunteerFormPage() {
  const navigate = useNavigate();

  const [showModal, setShowModal] = useState(false);
  const [skillsList, setSkillsList] = useState([]);
  const [limitationsList, setLimitationsList] = useState([]);
  const [showConsentModal,setshowConsentModal] = useState(false);
  const [payLoad,setPayload] = useState();


  useEffect(() => {
    fetchAllSkills();
    fetchAllLimitations();
  }, [])

  const fetchAllSkills = async () => {
    try {
      const { data } = await getAllSkills();
      if (data) {
        const transformedArr = data.map(({ code, skill }) => ({
          label: skill,
          value: code,
        }));
        setSkillsList(transformedArr)
      }
    } catch (error) {
      toast("Something went wrong, Please try again...", {
        duration: 5000,
        theme: "warning",
      });
    }
  };

  const fetchAllLimitations = async () => {
    try {
      const { data } = await getAllLimitations();
      if (data) {
        const transformedArr = data.map(({ code, limitation }) => ({
          label: limitation,
          value: code,
        }));
        setLimitationsList(transformedArr);
      }
    } catch (error) {
      toast("Something went wrong, Please try again...", {
        duration: 5000,
        theme: "warning",
      });
    }
  };

  const onAcceptConsent = async () => {
    try {
      const { data: createData } = await createVolunteer(payLoad);
      if (createData) {
        setShowModal(true);
        setshowConsentModal(false);
      }
    } catch (error) {
      toast("Something went wrong, Please try again...", {
        duration: 5000,
        theme: "warning",
      });
    }
  }

  const onSubmit = async (data) => {
    const payload = buildPayload(data, skillsList)
    if(payload){
      setPayload(payload)
      setshowConsentModal(true)
    }else{
      toast("Something went wrong, Form building Please try again...", {
        duration: 5000,
        theme: "warning",
      });
    }
  };

  const handleClose = () => {
    navigate('/');
    setShowModal(true);
  };

  const consentHandleClose = () => {
    navigate('/govemployee/volunteer');
    setshowConsentModal(false)
  }
  return (
    <div style={{ justifyContent: "center", alignItems: "center", padding: "10vh" }}>
      <FormComponent onSubmit={onSubmit} showModal={showModal} handleClose={handleClose} skillsList={skillsList} limitationsList={limitationsList} showConsentModal={showConsentModal} consentHandleClose={consentHandleClose} onAcceptConsent={onAcceptConsent}/>
    </div>
  )
}

export default VolunteerFormPage