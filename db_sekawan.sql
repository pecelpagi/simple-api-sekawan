--
-- PostgreSQL database dump
--

-- Dumped from database version 15.6 (Homebrew)
-- Dumped by pg_dump version 15.6 (Homebrew)

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
-- Name: contacts; Type: TABLE; Schema: public; Owner: galuhramadhan
--

CREATE TABLE public.contacts (
    id integer NOT NULL,
    first_name character varying(25) NOT NULL,
    middle_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    address character varying(100) NOT NULL,
    city character varying(50) NOT NULL,
    province character varying(50) NOT NULL,
    occupation character varying(100) NOT NULL,
    last_education character(4) NOT NULL,
    phone character(15) NOT NULL,
    email character varying(50) NOT NULL,
    image character varying(255),
    video character varying(255),
    document character varying(255)
);


ALTER TABLE public.contacts OWNER TO galuhramadhan;

--
-- Name: contacts_id_seq; Type: SEQUENCE; Schema: public; Owner: galuhramadhan
--

CREATE SEQUENCE public.contacts_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contacts_id_seq OWNER TO galuhramadhan;

--
-- Name: contacts_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: galuhramadhan
--

ALTER SEQUENCE public.contacts_id_seq OWNED BY public.contacts.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: galuhramadhan
--

CREATE TABLE public.users (
    id integer NOT NULL,
    username character varying(100) NOT NULL,
    password character varying(100) NOT NULL,
    name character varying(100) NOT NULL,
    token character varying(100),
    token_expired_at bigint
);


ALTER TABLE public.users OWNER TO galuhramadhan;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: galuhramadhan
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO galuhramadhan;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: galuhramadhan
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: contacts id; Type: DEFAULT; Schema: public; Owner: galuhramadhan
--

ALTER TABLE ONLY public.contacts ALTER COLUMN id SET DEFAULT nextval('public.contacts_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: galuhramadhan
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: contacts; Type: TABLE DATA; Schema: public; Owner: galuhramadhan
--

COPY public.contacts (id, first_name, middle_name, last_name, address, city, province, occupation, last_education, phone, email, image, video, document) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: galuhramadhan
--

COPY public.users (id, username, password, name, token, token_expired_at) FROM stdin;
1	test	$2a$10$uSZSPGSddrMQBAxNjrmoSuLkHvKhvf7SASFfkSMSYH4e9keWKJ/gS	Test Account	38d984f8-2d78-456a-969b-11cc6447514d	1717719138772
\.


--
-- Name: contacts_id_seq; Type: SEQUENCE SET; Schema: public; Owner: galuhramadhan
--

SELECT pg_catalog.setval('public.contacts_id_seq', 28, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: galuhramadhan
--

SELECT pg_catalog.setval('public.users_id_seq', 1, true);


--
-- Name: contacts contacts_pkey; Type: CONSTRAINT; Schema: public; Owner: galuhramadhan
--

ALTER TABLE ONLY public.contacts
    ADD CONSTRAINT contacts_pkey PRIMARY KEY (id);


--
-- Name: contacts unique_email; Type: CONSTRAINT; Schema: public; Owner: galuhramadhan
--

ALTER TABLE ONLY public.contacts
    ADD CONSTRAINT unique_email UNIQUE (email);


--
-- Name: contacts unique_phone; Type: CONSTRAINT; Schema: public; Owner: galuhramadhan
--

ALTER TABLE ONLY public.contacts
    ADD CONSTRAINT unique_phone UNIQUE (phone);


--
-- Name: users unique_token; Type: CONSTRAINT; Schema: public; Owner: galuhramadhan
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT unique_token UNIQUE (token);


--
-- Name: users unique_username; Type: CONSTRAINT; Schema: public; Owner: galuhramadhan
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT unique_username UNIQUE (username);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: galuhramadhan
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

