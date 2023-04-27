import mongoose from 'mongoose';
import { Request, Response } from "express";
import Procedure from '../model/Procedure';

export const addProcedure = (req: Request, res: Response) => {
  const procedure = new Procedure({
    id: new mongoose.Types.ObjectId(),
    ...req.body
  })

  return procedure.save()
    .then((procedure) => { res.status(201).json({ procedure }) })
    .catch((error) => { res.status(500).json({ error }) })
};

export const getAllProcedures = (req: Request, res: Response) => {

  return Procedure.find()
    .then((procedures) => { res.status(201).json( procedures ) })
    .catch((error) => { res.status(500).json({ error }) })
};

export const getProcedure = (req: Request, res: Response) => {

  return Procedure.findById(req.params.id)
    .then((procedure) => { res.status(201).json( procedure ) })
    .catch((error) => { res.status(500).json({ error }) })
};

export const deleteProcedure = (req: Request, res: Response) => {

  return Procedure.findByIdAndDelete(req.params.id)
    .then((procedure) => { res.status(201).json( procedure ) })
    .catch((error) => { res.status(500).json({ error }) })
};