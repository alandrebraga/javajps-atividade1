--
-- PostgreSQL database cluster dump
--

-- Started on 2023-04-22 23:57:05 -03

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'SCRAM-SHA-256$4096:0Mj52zDznJ81AF5gs5jSLA==$3LAa4mfqeviXFsaeAQNmR6Jn0tIKCfyZ5M22nXSHkKo=:QdelBvux0iLb1q/G8BmouEXxQfgddTOmw7WdYUgNcQA=';

--
-- User Configurations
--


--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2 (Ubuntu 15.2-1.pgdg22.04+1)
-- Dumped by pg_dump version 15.2 (Ubuntu 15.2-1.pgdg22.04+1)

-- Started on 2023-04-22 23:57:05 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2023-04-22 23:57:05 -03

--
-- PostgreSQL database dump complete
--

--
-- Database "financa" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2 (Ubuntu 15.2-1.pgdg22.04+1)
-- Dumped by pg_dump version 15.2 (Ubuntu 15.2-1.pgdg22.04+1)

-- Started on 2023-04-22 23:57:05 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3492 (class 1262 OID 16388)
-- Name: financa; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE financa WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.UTF-8';


ALTER DATABASE financa OWNER TO postgres;

\connect financa

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16390)
-- Name: financa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.financa (
    id integer NOT NULL,
    name character varying NOT NULL,
    tipo character varying NOT NULL,
    valor real NOT NULL
);


ALTER TABLE public.financa OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16389)
-- Name: financa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.financa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.financa_id_seq OWNER TO postgres;

--
-- TOC entry 3493 (class 0 OID 0)
-- Dependencies: 214
-- Name: financa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.financa_id_seq OWNED BY public.financa.id;


--
-- TOC entry 3340 (class 2604 OID 16393)
-- Name: financa id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.financa ALTER COLUMN id SET DEFAULT nextval('public.financa_id_seq'::regclass);


--
-- TOC entry 3486 (class 0 OID 16390)
-- Dependencies: 215
-- Data for Name: financa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.financa (id, name, tipo, valor) FROM stdin;
5	Hamburguer	saida	34.5
11	pizza	entrada	62
12	pagamento	entrada	2000
13	Sushi	entrada	300
28	Pizza	saida	55.2
30	pizza	entrada	55.3
31	Pizza	saida	123
\.


--
-- TOC entry 3494 (class 0 OID 0)
-- Dependencies: 214
-- Name: financa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.financa_id_seq', 31, true);


--
-- TOC entry 3342 (class 2606 OID 16397)
-- Name: financa financa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.financa
    ADD CONSTRAINT financa_pkey PRIMARY KEY (id);


-- Completed on 2023-04-22 23:57:05 -03

--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

\connect postgres

--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2 (Ubuntu 15.2-1.pgdg22.04+1)
-- Dumped by pg_dump version 15.2 (Ubuntu 15.2-1.pgdg22.04+1)

-- Started on 2023-04-22 23:57:05 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2023-04-22 23:57:05 -03

--
-- PostgreSQL database dump complete
--

-- Completed on 2023-04-22 23:57:05 -03

--
-- PostgreSQL database cluster dump complete
--

