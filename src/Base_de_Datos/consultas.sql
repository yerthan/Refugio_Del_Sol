-- select * from Reserva r left join Habitacion h on r.HabitacionID = h.ID left join Regimen re on r.RegimenID = re.ID left join Extras e on r.ExtrasID = e.ID;

select h.ID, h.Precio from Reserva r inner join  Habitacion h on r.HabitacionID = h.ID and r.id = 1;
-- sacas id's

select re.ID, re.Precio from Reserva r inner join Regimen re on r.ID = re.ID and r.ID = 1;

select e.ID, e.Precio from Reserva r inner join Extras e on r.ExtrasID = e.ID and r.ID = 1;

-- guardar las consultas en un array list de doubles, se suman y se multiplican por los dias
