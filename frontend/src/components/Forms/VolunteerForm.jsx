import React from "react";
import { Form } from "@formio/react";

import ConfirmationModal from "./Modal";
import { buildForm } from "./impl";

import './Styles/formStyles.css';
import ConsentModal from "./Modal/consent";

const FormComponent = (props) => {
  const { onSubmit, showModal, handleClose, skillsList, limitationsList,showConsentModal,consentHandleClose,onAcceptConsent } = props

  return (
    <div className="form_page">
      <Form form={buildForm(skillsList, limitationsList)} onSubmit={onSubmit} />
      <ConsentModal showModal={showConsentModal} handleClose={consentHandleClose} onAcceptConsent={onAcceptConsent}></ConsentModal>
      <ConfirmationModal showModal={showModal} handleClose={handleClose} />
    </div>
  );
};

export default FormComponent;
