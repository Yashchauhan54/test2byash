package org.example.test2yash;

public class patient_record {
    private int RecordID;
    private String PatientName;
    private String Diagnosis;
    private String Treatment;

    public patient_record(int RecordID, String PatientName, String Diagnosis, String Treatment) {
        this.PatientName = PatientName;
        this.RecordID = RecordID;
        this.Diagnosis = Diagnosis;
        this.Treatment = Treatment;
    }

    public int getRecordID() {
        return RecordID;
    }

    public void setRecordID(int recordID) {
        RecordID = recordID;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public String getDiagnosis() {
        return Diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        Diagnosis = diagnosis;
    }

    public String getTreatment() {
        return Treatment;
    }

    public void setTreatment(String treatment) {
        Treatment = treatment;
    }
}




