import mongoose from 'mongoose';
import { NextFunction, Request, Response } from "express";
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

export const getAppointmentsByDate = (req: Request, res: Response, next: NextFunction) => {
  if(!req.query.date) return next();

  return Appointment.find({date: req.query.date})
    .then((appointments) => { res.status(201).json(appointments) })
    .catch((error) => { res.status(500).json({ error }) })
};

export const deleteAppointment = (req: Request, res: Response) => {

  return Appointment.findByIdAndDelete(req.params.id)
    .then((appointment) => { res.status(201).json({ appointment }) })
    .catch((error) => { res.status(500).json({ error }) })
};

export const getAppointmentsByPatient = (req: Request, res: Response, next: NextFunction) => {
  if(!req.query.patientId) return next();
  
  return Appointment.find({patientId: req.query.patientId})
    .then((appointment) => { res.status(201).json( appointment ) })
    .catch((error) => { res.status(500).json({ error }) })
};