--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

-- Started on 2024-09-14 23:11:20

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
-- TOC entry 215 (class 1259 OID 30076)
-- Name: matches; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.matches (
    date date NOT NULL,
    id bigint NOT NULL,
    teama_id bigint NOT NULL,
    teamb_id bigint NOT NULL,
    score character varying(255) NOT NULL
);


ALTER TABLE public.matches OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 30081)
-- Name: players; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.players (
    id bigint NOT NULL,
    team_id bigint NOT NULL,
    team_number bigint NOT NULL,
    full_name character varying(255) NOT NULL,
    "position" character varying(255) NOT NULL,
    CONSTRAINT players_position_check CHECK ((("position")::text = ANY ((ARRAY['GK'::character varying, 'DF'::character varying, 'MF'::character varying, 'FW'::character varying])::text[])))
);


ALTER TABLE public.players OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 30089)
-- Name: records; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.records (
    from_minutes integer NOT NULL,
    to_minutes integer,
    id bigint NOT NULL,
    match_id bigint NOT NULL,
    player_id bigint NOT NULL,
    CONSTRAINT records_from_minutes_check CHECK (((from_minutes <= 90) AND (from_minutes >= 0))),
    CONSTRAINT records_to_minutes_check CHECK ((to_minutes <= 90))
);


ALTER TABLE public.records OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 30096)
-- Name: teams; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.teams (
    group_name character(1) NOT NULL,
    id bigint NOT NULL,
    manager_full_name character varying(255) NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.teams OWNER TO postgres;

--
-- TOC entry 4699 (class 2606 OID 30080)
-- Name: matches matches_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matches
    ADD CONSTRAINT matches_pkey PRIMARY KEY (id);


--
-- TOC entry 4701 (class 2606 OID 30088)
-- Name: players players_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.players
    ADD CONSTRAINT players_pkey PRIMARY KEY (id);


--
-- TOC entry 4703 (class 2606 OID 30095)
-- Name: records records_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.records
    ADD CONSTRAINT records_pkey PRIMARY KEY (id);


--
-- TOC entry 4705 (class 2606 OID 30104)
-- Name: teams teams_manager_full_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teams
    ADD CONSTRAINT teams_manager_full_name_key UNIQUE (manager_full_name);


--
-- TOC entry 4707 (class 2606 OID 30106)
-- Name: teams teams_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teams
    ADD CONSTRAINT teams_name_key UNIQUE (name);


--
-- TOC entry 4709 (class 2606 OID 30102)
-- Name: teams teams_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teams
    ADD CONSTRAINT teams_pkey PRIMARY KEY (id);


--
-- TOC entry 4712 (class 2606 OID 30117)
-- Name: players fk5nglidr00c4dyybl171v6kask; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.players
    ADD CONSTRAINT fk5nglidr00c4dyybl171v6kask FOREIGN KEY (team_id) REFERENCES public.teams(id);


--
-- TOC entry 4713 (class 2606 OID 30122)
-- Name: records fk6pn8n0bpajrrlu5y0y7pp0tkf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.records
    ADD CONSTRAINT fk6pn8n0bpajrrlu5y0y7pp0tkf FOREIGN KEY (match_id) REFERENCES public.matches(id);


--
-- TOC entry 4710 (class 2606 OID 30112)
-- Name: matches fk9qbj89kw20wkdbu4d1k9ay2s1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matches
    ADD CONSTRAINT fk9qbj89kw20wkdbu4d1k9ay2s1 FOREIGN KEY (teamb_id) REFERENCES public.teams(id);


--
-- TOC entry 4711 (class 2606 OID 30107)
-- Name: matches fkad201e1i54u4uu7ktkxo9jvq7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matches
    ADD CONSTRAINT fkad201e1i54u4uu7ktkxo9jvq7 FOREIGN KEY (teama_id) REFERENCES public.teams(id);


--
-- TOC entry 4714 (class 2606 OID 30127)
-- Name: records fkq95t39uxr80s0pr0nv4rjyo6n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.records
    ADD CONSTRAINT fkq95t39uxr80s0pr0nv4rjyo6n FOREIGN KEY (player_id) REFERENCES public.players(id);


-- Completed on 2024-09-14 23:11:20

--
-- PostgreSQL database dump complete
--

