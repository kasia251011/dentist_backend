import mongoose from 'mongoose';
import { Request, Response } from "express";
import Patient from '../model/patient/Patient';
import { Tooth } from '../model/patient/Tooth';

export const addPatient = (req: Request, res: Response) => {
  const patient = new Patient({
    id: new mongoose.Types.ObjectId(),
    ...req.body
  })

  for (let i = 1; i <= 32; i++) {
    const tooth: Tooth= {
      no: i,
      state: 'HEALTHY',
      hitory: []
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

export const deletePatient = (req: Request, res: Response) => {

  return Patient.findByIdAndDelete(req.params.id)
    .then((patient) => { res.status(201).json( patient ) })
    .catch((error) => { res.status(500).json({ error }) })
};

export const pushToothHistory = async (req: Request, res: Response) => {
  const patientid = req.params.patientId;
  const toothId = Number(req.params.toothId);
  const newHistory = req.body;

  try {
    const patient = await Patient.findById(patientid);
    patient?.teeth[toothId].hitory.push(newHistory);
    await patient?.save();
    res.status(201).json(patient);
  } catch (error) {
    res.status(500).json({ error });
  }
}