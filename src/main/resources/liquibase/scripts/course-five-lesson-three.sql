-- liquibase formatted sql

-- changeset nkulakov:1
CREATE INDEX student_name_index ON student (name)

--changeset nkulakov:2
CREATE INDEX faculty_nc_index ON faculty (name, color)