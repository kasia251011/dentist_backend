import mongoose from 'mongoose';
import { Request, Response } from "express";
import Patient from '../model/patient/Patient';
import { Tooth } from '../model/patient/Tooth';
import { Diagnosis } from '../model/patient/Diagnosis';

export const addPatient = (req: Request, res: Response) => {
  const patient = new Patient({
    id: new mongoose.Types.ObjectId(),
    ...req.body
  })

  for (let i = 1; i <= 32; i++) {
    const tooth: Tooth= {
      no: i,
      state: 'HEALTHY',
      diagnoses: []
    };

    patient.teeth.push(tooth);
  }

  return patient.save()
    .then((patient) => { res.status(201).json( patient ) })
    .catch((error) => { res.status(500).json( error ) })
};

export const getAllPatients = (req: Request, res: Response) => {

  return Patient.find()
    .then((patient) => { res.status(201).json( patient ) })
    .catch((error) => { res.status(500).json({ error }) })
};

export const getPatient = (req: Request, res: Response) => {

  return Patient.findById(req.params.id)
    .then((patient) => { res.status(201).json( patient ) })
    .catch((error) => { res.status(500).json({ error }) })
};

export const getPatientTeeth = (req: Request, res: Response) => {

  return Patient.findById(req.params.id)
    .then((patient) => { res.status(201).json( patient?.teeth ) })
    .catch((error) => { res.status(500).json({ error }) })
};

export const getPatientDiagnosisTooth = (req: Request, res: Response) => {

  const id = req.params.patientId;
  const toothNo = parseInt(req.params.toothNo);
  const index = parseInt(req.params.index);

  return Patient.findById(id)
    .then((patient) => { 
      res.status(201).json( 
        patient?.teeth.find(
          (t) => t.no === toothNo)?.
          diagnoses[index])
        })
    .catch((error) => { res.status(500).json({ error }) })
};


export const deletePatient = (req: Request, res: Response) => {

  return Patient.findByIdAndDelete(req.params.id)
    .then((patient) => { res.status(201).json( patient ) })
    .catch((error) => { res.status(500).json({ error }) })
};

export const pushToothDiagnosisByToothNo = async (req: Request, res: Response) => {
  const patientId = req.params.patientId;
  const toothNo = Number(req.params.toothNo);

  const newDiagnosis: Diagnosis = {
    date: req.body.date,
    description: req.body.description,
    src: req.body.src
  }

  try {
    const patient = await Patient.findById(patientId);
    patient?.teeth.find((t) => toothNo === t.no)?.diagnoses.push(newDiagnosis);
    await patient?.save();
    res.status(201).json(patient);
  } catch (error) {
    res.status(500).json({ error });
  }
}

export const updateTooth = async (req: Request, res: Response) => {
  const patientId = req.params.patientId;
  const toothNo = Number(req.params.toothNo) ?? 0;
  const state = req.body.state;

  console.log(state);

  try {
    const patient = await Patient.findById(patientId);
    const teeth =  patient?.teeth;
    const tooth = teeth?.find((t) => toothNo === t.no);
    if(tooth && patient) {
      tooth.state = state;
      const newTeeth = teeth?.map(t => t.no == toothNo ? tooth : t)
      console.log(newTeeth);
      patient.save()
    }
    res.status(201).json(patient);
  } catch (error) {
    res.status(500).json({ error });
  }
}