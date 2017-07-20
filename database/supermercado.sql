--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.5
-- Dumped by pg_dump version 9.6.2

-- Started on 2017-06-25 20:43:49 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 176 (class 1259 OID 927347)
-- Name: funcionarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE produtos (
    id integer NOT NULL,
    nome character varying(30) NOT NULL,
    cpf character varying(14) NOT NULL,
    email character varying(35),
    nascimento date,
    telefone character varying(20)
);


ALTER TABLE funcionarios OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 927345)
-- Name: funcionarios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE funcionarios_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE funcionarios_id_seq OWNER TO postgres;

--
-- TOC entry 2271 (class 0 OID 0)
-- Dependencies: 175
-- Name: funcionarios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE funcionarios_id_seq OWNED BY funcionarios.id;


--
-- TOC entry 2151 (class 2604 OID 927350)
-- Name: funcionarios id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionarios ALTER COLUMN id SET DEFAULT nextval('funcionarios_id_seq'::regclass);


--
-- TOC entry 2266 (class 0 OID 927347)
-- Dependencies: 176
-- Data for Name: funcionarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO funcionarios (id, nome, cpf, email, nascimento, telefone) VALUES (1, 'Gabriel', '123.456.789-10', 'gabriel@gmail.com', '1994-05-06', '6299991234');
INSERT INTO funcionarios (id, nome, cpf, email, nascimento, telefone) VALUES (2, 'Paulo', '123.456.789-11', 'paulo@gmail.com', '1995-10-10', '6299991235');
INSERT INTO funcionarios (id, nome, cpf, email, nascimento, telefone) VALUES (3, 'Thiago', '123.456.789-12', 'thiago@gmail.com', '1994-02-10', '6299991236');


--
-- TOC entry 2272 (class 0 OID 0)
-- Dependencies: 175
-- Name: funcionarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('funcionarios_id_seq', 3, true);


--
-- TOC entry 2153 (class 2606 OID 927354)
-- Name: funcionarios cpf_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionarios
    ADD CONSTRAINT cpf_unique UNIQUE (cpf);


--
-- TOC entry 2155 (class 2606 OID 927352)
-- Name: funcionarios funcionarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionarios
    ADD CONSTRAINT funcionarios_pkey PRIMARY KEY (id);


-- Completed on 2017-06-25 20:43:49 -03

--
-- PostgreSQL database dump complete
--

