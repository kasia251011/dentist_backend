import mongoose from 'mongoose';
import { Request, Response } from "express";
import Appointment from '../model/Appointment';

export const addAppointment = (req: Request, res: Response) => {
  const appointment = new Appointment({
    id: new mongoose.Types.ObjectId(),
    ...req.body
  })

  return appointment.save()
    .then((appointment) => { res.status(201).json({ appointment }) })
    .catch((error) => { res.status(500).json({ error }) })
};

export const getAllAppointments = (req: Request, res: Response) => {

  return Appointment.find()
    .then((appointment) => { res.status(201).json({ appointment }) })
    .catch((error) => { res.status(500).json({ error }) })
};

export const getAppointment = (req: Request, res: Response) => {

  return Appointment.findById(req.params.id)
    .then((appointment) => { res.status(201).json({ appointment }) })
    .catch((error) => { res.status(500).json({ error }) })
};

export const deleteAppointment = (req: Request, res: Response) => {

  return Appointment.findByIdAndDelete(req.params.id)
    .then((appointment) => { res.status(201).json({ appointment }) })
    .catch((error) => { res.status(500).json({ error }) })
};

export const getAppointmentsByPatient = (req: Request, res: Response) => {

  return Appointment.find({patient: req.params.patientId})
    .then((appointment) => { res.status(201).json({ appointment }) })
    .catch((error) => { res.status(500).json({ error }) })
};