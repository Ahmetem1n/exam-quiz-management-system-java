--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4
-- Dumped by pg_dump version 13.4

-- Started on 2021-12-29 10:51:45

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
-- TOC entry 208 (class 1259 OID 18744)
-- Name: admins; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.admins (
    admin_id integer NOT NULL,
    user_id integer NOT NULL
);


ALTER TABLE public.admins OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 18749)
-- Name: admins_admin_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.admins ALTER COLUMN admin_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.admins_admin_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 205 (class 1259 OID 18719)
-- Name: departments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.departments (
    department_id integer NOT NULL,
    faculty_id integer NOT NULL,
    department_name character varying NOT NULL
);


ALTER TABLE public.departments OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 18751)
-- Name: department_department_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.departments ALTER COLUMN department_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.department_department_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 225 (class 1259 OID 27715)
-- Name: exam_result; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exam_result (
    result_id integer NOT NULL,
    exam_id integer NOT NULL,
    student_id integer NOT NULL,
    result integer NOT NULL
);


ALTER TABLE public.exam_result OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 27713)
-- Name: exam_result_result_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.exam_result ALTER COLUMN result_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.exam_result_result_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 206 (class 1259 OID 18730)
-- Name: exams; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exams (
    exam_id integer NOT NULL,
    lesson_id integer NOT NULL,
    active boolean NOT NULL
);


ALTER TABLE public.exams OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 18753)
-- Name: exams_exam_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.exams ALTER COLUMN exam_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.exams_exam_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 204 (class 1259 OID 18711)
-- Name: faculties; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.faculties (
    faculty_id integer NOT NULL,
    faculty_name character varying NOT NULL
);


ALTER TABLE public.faculties OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 18755)
-- Name: faculty_faculty_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.faculties ALTER COLUMN faculty_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.faculty_faculty_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 226 (class 1259 OID 27720)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 18677)
-- Name: lessons; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lessons (
    lesson_id integer NOT NULL,
    teacher_id integer NOT NULL,
    department_id integer NOT NULL,
    lesson_name character varying NOT NULL,
    lesson_teams_code character varying NOT NULL,
    lesson_material_link character varying NOT NULL
);


ALTER TABLE public.lessons OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 18757)
-- Name: lessons_lesson_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.lessons ALTER COLUMN lesson_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.lessons_lesson_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 207 (class 1259 OID 18736)
-- Name: questions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.questions (
    question_id integer NOT NULL,
    exam_id integer NOT NULL,
    question_text character varying NOT NULL,
    option_a character varying NOT NULL,
    option_b character varying NOT NULL,
    option_c character varying NOT NULL,
    option_d character varying NOT NULL,
    option_e character varying NOT NULL,
    true_option character varying(1) NOT NULL
);


ALTER TABLE public.questions OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 18759)
-- Name: questions_question_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.questions ALTER COLUMN question_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.questions_question_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 221 (class 1259 OID 27047)
-- Name: questions_students; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.questions_students (
    detail_id integer NOT NULL,
    student_id integer NOT NULL,
    question_id integer NOT NULL,
    marked_option character varying(1) NOT NULL
);


ALTER TABLE public.questions_students OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 27045)
-- Name: questions_students_detail_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.questions_students ALTER COLUMN detail_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.questions_students_detail_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 218 (class 1259 OID 26876)
-- Name: student_lesson_relationship; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student_lesson_relationship (
    relationship_id integer NOT NULL,
    lesson_id integer NOT NULL,
    student_id integer NOT NULL
);


ALTER TABLE public.student_lesson_relationship OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 27043)
-- Name: student_lesson_relationship_relationship_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.student_lesson_relationship ALTER COLUMN relationship_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.student_lesson_relationship_relationship_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 200 (class 1259 OID 18657)
-- Name: students; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.students (
    student_id integer NOT NULL,
    user_id integer NOT NULL,
    student_number character varying(10) NOT NULL,
    student_grade integer NOT NULL,
    department_id integer NOT NULL
);


ALTER TABLE public.students OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 18761)
-- Name: students_student_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.students ALTER COLUMN student_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.students_student_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 201 (class 1259 OID 18660)
-- Name: teachers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.teachers (
    teacher_id integer NOT NULL,
    user_id integer NOT NULL,
    profession character varying NOT NULL,
    department_id integer NOT NULL
);


ALTER TABLE public.teachers OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 18763)
-- Name: teachers_teacher_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.teachers ALTER COLUMN teacher_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.teachers_teacher_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 223 (class 1259 OID 27323)
-- Name: user_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_roles (
    role_id integer NOT NULL,
    role_name character varying NOT NULL
);


ALTER TABLE public.user_roles OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 27321)
-- Name: user_roles_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.user_roles ALTER COLUMN role_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.user_roles_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 203 (class 1259 OID 18682)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id integer NOT NULL,
    role_id integer NOT NULL,
    user_firstname character varying NOT NULL,
    user_lastname character varying NOT NULL,
    user_email character varying NOT NULL,
    user_nationality_id character varying(11) NOT NULL,
    user_gender character varying NOT NULL,
    user_photo character varying(99999) NOT NULL,
    user_password character varying NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 18767)
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.users ALTER COLUMN user_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.users_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3122 (class 0 OID 18744)
-- Dependencies: 208
-- Data for Name: admins; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.admins (admin_id, user_id) FROM stdin;
1	1
\.


--
-- TOC entry 3119 (class 0 OID 18719)
-- Dependencies: 205
-- Data for Name: departments; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.departments (department_id, faculty_id, department_name) FROM stdin;
1	1	Bilgisayar Mühendisliği
2	1	Elektrik-Elektronik Mühendisliği
4	4	Kimya Bölümü
5	4	Matematik Bölümü
6	3	Fiziksel Tıp ve Rehabilitasyon
7	2	Fransız Dili ve Edebiyatı
8	3	Ortopedist
9	1	Nanoteknoloji Mühendisliği
3	2	Psikoloji Bölümü
\.


--
-- TOC entry 3139 (class 0 OID 27715)
-- Dependencies: 225
-- Data for Name: exam_result; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.exam_result (result_id, exam_id, student_id, result) FROM stdin;
9	1	4	20
7	5	1	90
8	5	3	80
\.


--
-- TOC entry 3120 (class 0 OID 18730)
-- Dependencies: 206
-- Data for Name: exams; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.exams (exam_id, lesson_id, active) FROM stdin;
3	7	f
4	5	f
5	2	t
2	3	f
1	1	t
6	1	f
\.


--
-- TOC entry 3118 (class 0 OID 18711)
-- Dependencies: 204
-- Data for Name: faculties; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.faculties (faculty_id, faculty_name) FROM stdin;
1	Mühendislik Fakültesi
2	Edebiyat Fakültesi
3	Tıp Fakültesi
4	Fen Fakültesi
5	Mimarlık Fakültesi
\.


--
-- TOC entry 3116 (class 0 OID 18677)
-- Dependencies: 202
-- Data for Name: lessons; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.lessons (lesson_id, teacher_id, department_id, lesson_name, lesson_teams_code, lesson_material_link) FROM stdin;
2	5	1	Matematik	mt123	ekampus.cumhuriyet.edu.tr
3	5	2	Diferansiyel Denklemler	df123	ekampus.cumhuriyet.edu.tr
4	2	1	Veri Madenciliği	vm123	ekampus.cumhuriyet.edu.tr
5	2	1	Olasılık	ol123	ekampus.cumhuriyet.edu.tr
7	3	6	Fiziksel Hareketler	fh123	ekampus.cumhuriyet.edu.tr
8	3	6	Rehabilite Temeli	rt123	ekampus.cumhuriyet.edu.tr
9	4	4	Organik Kimya	ok123	ekampus.cumhuriyet.edu.tr
10	4	1	Genel Kimya	gk123	ekampus.cumhuriyet.edu.tr
11	2	1	Algoritma Analizi	aa123	ekampus.cumhuriyet.edu.tr
6	1	3	Deneysel Psikoloji	dp123	ekampus.cumhuriyet.edu.tr
1	1	3	Psikolojiye Giriş	ps123	ekampus.cumhuriyet.edu.tr
\.


--
-- TOC entry 3121 (class 0 OID 18736)
-- Dependencies: 207
-- Data for Name: questions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.questions (question_id, exam_id, question_text, option_a, option_b, option_c, option_d, option_e, true_option) FROM stdin;
7	5	Bir satıcı toptancıdan tanesi 40 TL olan tişörtlerden 32 tane almıştır. Buna göre satıcı kaç TL vermiştir ?	1080	1100	1180	1280	1380	D
8	5	Üç basamaklı bir doğal sayı ile iki basamaklı doğal sayının çarpımları en az kaçtır ?	1001	1000	0	1010	100	B
9	5	Ayşe, cebindeki parasıyla tanesi 25 TL  olan defterden 10 tane alırsa 125 TL' si artıyor. Ayşe cebindeki parayla tanesi 15 TL  olan defterlerden kaç tane alır ?	25	20	30	35	40	A
10	5	4 katı 160 olan sayının, 40 fazlasının 5 katı kaçtır ?	200	300	400	350	440	C
1	5	Aşağıdakilerden hangisi doğrudur?	5 + 5 =10	6 - 9 = 3	18 * 4 = 61	25 / 7 = 5	30 * 8 = 120	A
2	5	9*8 işleminin sonucu kaçtır?	65	72	84	81	69	B
3	5	24 ün 5 ile bölümünden kalan kaçtır ?	0	1	2	3	4	E
4	5	Bir sayı -1 ile çarpılınca sonuç ne olur ?	Sayının kendisi	Sayının negatif hali	0	-1	1	B
5	5	Bir sayı 0 ile bölünürse sonuç ne olur? 	0	1	Sayının kendisi	Sayının negatif hali	Hiçbiri	E
6	5	I) 6 * 5 = 30\nII) 7 * 5 = 42\nIII) 16 + 9 = 24\nIV) 36 + 7 = 43\nNumaralandırılmış işlemlerden hangisi veya hangileri doğrudur ?	II - III	I - II - IV	I - IV	II - IV	I - II	C
11	1	Aşağıdakilerden hangisi öncelikle klinik psikolojinin inceleme alanına girer?	Öğrenme ve öğretmen ilkeleri	Davranış bozukluklarının teşhisi	Davranış farklılıklarının ölçümü için test geliştirme	Davranışın fizyolojik temelleri	İş verimliliğinin arttırılması	B
12	1	Korelasyonel yöntemlerin bir araştırma tekniğini alarak kullanılmasının temelinde aşağıdakilerden hangisi vardır?	Değişkenler arasındaki ilişkiyi incelemesi	Nesnel olması	Uyaran - tepki ilişkisini açıklaması	Doğrulanabilmesi	Kesin sonuçlar vermesi	A
13	1	İntihar girişiminde bulanan bir genç kızın bu davranışını anlamak isteyen psikolog, genç kızın çocukluktan beri geçirdiği aşamaları aile içi ilişkilerini, eğitim durumunu ve arkadaşlık ilişkilerini incelemiştir.	Deney	Mülakat	Gözlem	Test	Vak'a İncelemesi	E
14	1	Organizmanın yapısını ve işleyişini bilme, davranışların anlamlandırılmasın! ve açıklanması kolaylaştırır.  Bu alanda psikolojiye yardımcıdan bilim aşağıdakilerden hangisidir?	Felsefe	Antropoloji	Sosyoloji	Fizik	Biyoloji	E
16	1	İnsanların küme içi davranışlarını, grup - birey ilişkilerini inceleyen psikoloji dalı aşağıdakilerden hangisidir?	Sosyal psikoloji	Klinik Psikolojik	Eğitim psikolojisi	Deneysel psikoloji	Gelişim psikoloji	A
\.


--
-- TOC entry 3135 (class 0 OID 27047)
-- Dependencies: 221
-- Data for Name: questions_students; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.questions_students (detail_id, student_id, question_id, marked_option) FROM stdin;
8	1	8	B
10	1	10	E
1	1	1	A
2	1	2	B
3	1	3	E
4	1	4	B
5	1	5	E
6	1	6	C
7	1	7	D
9	1	9	A
58	3	7	D
59	3	8	B
60	3	9	A
61	3	10	C
57	4	11	D
54	4	12	D
62	3	1	A
63	3	2	B
53	4	13	C
55	4	14	D
56	4	16	A
66	3	5	E
67	3	6	C
64	3	3	C
65	3	4	A
\.


--
-- TOC entry 3132 (class 0 OID 26876)
-- Dependencies: 218
-- Data for Name: student_lesson_relationship; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.student_lesson_relationship (relationship_id, lesson_id, student_id) FROM stdin;
1	2	1
2	3	1
3	1	4
5	2	3
\.


--
-- TOC entry 3114 (class 0 OID 18657)
-- Dependencies: 200
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.students (student_id, user_id, student_number, student_grade, department_id) FROM stdin;
1	7	2018141001	2	1
2	8	2018141002	3	2
3	9	2018141054	1	4
4	10	2018141068	2	3
5	11	2018141034	4	2
6	12	2018141027	4	1
\.


--
-- TOC entry 3115 (class 0 OID 18660)
-- Dependencies: 201
-- Data for Name: teachers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.teachers (teacher_id, user_id, profession, department_id) FROM stdin;
1	2	Psikolojik Travmalar	2
2	3	Yapay Zeka	1
3	4	Fiziksel Tedavi	1
4	5	Kimyasal Tepkimeler	4
5	6	Matematik	3
\.


--
-- TOC entry 3137 (class 0 OID 27323)
-- Dependencies: 223
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_roles (role_id, role_name) FROM stdin;
1	Admin
2	Teacher
3	Student
\.


--
-- TOC entry 3117 (class 0 OID 18682)
-- Dependencies: 203
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (user_id, role_id, user_firstname, user_lastname, user_email, user_nationality_id, user_gender, user_photo, user_password) FROM stdin;
3	2	Mahmut Sami	Orta	sami@mail	65213974582	Erkek	https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSarw8TksnWy10O8Z1zni87_Pv_MfLTIiIWEA&usqp=CAU	123
4	2	Asena	Koru	asena@mail	95684563794	Kadın	https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS19tE6u_dlETAdtqY3r56ZRA9AeYeyFrox4Q&usqp=CAU	123
5	2	Fahri	Batur	fahri@mail	75681569452	Erkek	https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHlssSZaNBAs6f3Dk0UPZxYv6LGcWhS2UpFQ&usqp=CAU	123
6	2	Elif	Nihal	elif@mail	51234856123	Kadın	https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRncguziwstmHVvM8mhOZN1RU_8hgZBowXdDA&usqp=CAU	123
8	3	Bulut	Özkanlı	bulut@mail	51230694515	Erkek	https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwmdsGafOhlRvU-ycHpSPGnJ_vuJY5Fun0-g&usqp=CAU	000
9	3	Zekiye	Yücetürk	zekiye@mail	23456126312	Kadın	https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTx_QwCh2y11_dLvfQNvKsrIHVRxsiOZexPdw&usqp=CAU	000
10	3	Ersin	Kiriş	ersin@mail	61204125645	Erkek	https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQL8VXXcQ3uSE-BcYIv1Md_V9u87OpaeR3gGw&usqp=CAU	000
11	3	Hazal	Çabuk	hazal@mail	21389764515	Kadın	https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkldFlVgsfecHwGLWzLFoGddckZBQyifdLgg&usqp=CAU	000
12	3	Alper	Kuyucu	alper@mail	54326485447	Erkek	https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPLSScXiHX70UTaBbK9Y3mjiUQLLIX5gfM6w&usqp=CAU	000
2	2	Ali	Yüzer	ali@mail	2	Erkek	https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVey9GSYFhSE7ejp_saomvmjxKVCRwRzuecA	123
7	3	Hamza	Çeviker	hamza@mail	3	Erkek	https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrCq_XZ6NNUqYW0rFkKYTgmNHUEqJ8K_O7Yw	000
1	1	Ahmet Emin	Kılıç	admin@mail	1	Erkek	https://thumbs.dreamstime.com/b/admin-sign-laptop-icon-stock-vector-166205404.jpg	1
\.


--
-- TOC entry 3146 (class 0 OID 0)
-- Dependencies: 209
-- Name: admins_admin_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.admins_admin_id_seq', 1, true);


--
-- TOC entry 3147 (class 0 OID 0)
-- Dependencies: 210
-- Name: department_department_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.department_department_id_seq', 9, true);


--
-- TOC entry 3148 (class 0 OID 0)
-- Dependencies: 224
-- Name: exam_result_result_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.exam_result_result_id_seq', 8, true);


--
-- TOC entry 3149 (class 0 OID 0)
-- Dependencies: 211
-- Name: exams_exam_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.exams_exam_id_seq', 8, true);


--
-- TOC entry 3150 (class 0 OID 0)
-- Dependencies: 212
-- Name: faculty_faculty_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.faculty_faculty_id_seq', 6, true);


--
-- TOC entry 3151 (class 0 OID 0)
-- Dependencies: 226
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 9, true);


--
-- TOC entry 3152 (class 0 OID 0)
-- Dependencies: 213
-- Name: lessons_lesson_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.lessons_lesson_id_seq', 18, true);


--
-- TOC entry 3153 (class 0 OID 0)
-- Dependencies: 214
-- Name: questions_question_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.questions_question_id_seq', 21, true);


--
-- TOC entry 3154 (class 0 OID 0)
-- Dependencies: 220
-- Name: questions_students_detail_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.questions_students_detail_id_seq', 67, true);


--
-- TOC entry 3155 (class 0 OID 0)
-- Dependencies: 219
-- Name: student_lesson_relationship_relationship_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.student_lesson_relationship_relationship_id_seq', 5, true);


--
-- TOC entry 3156 (class 0 OID 0)
-- Dependencies: 215
-- Name: students_student_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.students_student_id_seq', 6, true);


--
-- TOC entry 3157 (class 0 OID 0)
-- Dependencies: 216
-- Name: teachers_teacher_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.teachers_teacher_id_seq', 5, true);


--
-- TOC entry 3158 (class 0 OID 0)
-- Dependencies: 222
-- Name: user_roles_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_roles_role_id_seq', 3, true);


--
-- TOC entry 3159 (class 0 OID 0)
-- Dependencies: 217
-- Name: users_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_user_id_seq', 16, true);


--
-- TOC entry 2956 (class 2606 OID 18748)
-- Name: admins admins_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admins
    ADD CONSTRAINT admins_pkey PRIMARY KEY (admin_id);


--
-- TOC entry 2950 (class 2606 OID 18726)
-- Name: departments department_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departments
    ADD CONSTRAINT department_pkey PRIMARY KEY (department_id);


--
-- TOC entry 2966 (class 2606 OID 27719)
-- Name: exam_result exam_result_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam_result
    ADD CONSTRAINT exam_result_pkey PRIMARY KEY (result_id);


--
-- TOC entry 2952 (class 2606 OID 18734)
-- Name: exams exams_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exams
    ADD CONSTRAINT exams_pkey PRIMARY KEY (exam_id);


--
-- TOC entry 2948 (class 2606 OID 18718)
-- Name: faculties faculty_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.faculties
    ADD CONSTRAINT faculty_pkey PRIMARY KEY (faculty_id);


--
-- TOC entry 2939 (class 2606 OID 18681)
-- Name: lessons lessons_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT lessons_pkey PRIMARY KEY (lesson_id);


--
-- TOC entry 2954 (class 2606 OID 18743)
-- Name: questions questions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.questions
    ADD CONSTRAINT questions_pkey PRIMARY KEY (question_id);


--
-- TOC entry 2961 (class 2606 OID 27051)
-- Name: questions_students questions_students_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.questions_students
    ADD CONSTRAINT questions_students_pkey PRIMARY KEY (detail_id);


--
-- TOC entry 2959 (class 2606 OID 26880)
-- Name: student_lesson_relationship student_lesson_relationship_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_lesson_relationship
    ADD CONSTRAINT student_lesson_relationship_pkey PRIMARY KEY (relationship_id);


--
-- TOC entry 2933 (class 2606 OID 18695)
-- Name: students students_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.students
    ADD CONSTRAINT students_pkey PRIMARY KEY (student_id);


--
-- TOC entry 2936 (class 2606 OID 18766)
-- Name: teachers teachers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT teachers_pkey PRIMARY KEY (teacher_id);


--
-- TOC entry 2964 (class 2606 OID 27330)
-- Name: user_roles user_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (role_id);


--
-- TOC entry 2945 (class 2606 OID 18689)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2941 (class 1259 OID 27028)
-- Name: email; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX email ON public.users USING btree (user_email);


--
-- TOC entry 2946 (class 1259 OID 18797)
-- Name: faculty_name; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX faculty_name ON public.faculties USING btree (faculty_name);


--
-- TOC entry 2942 (class 1259 OID 27030)
-- Name: nationalityId; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX "nationalityId" ON public.users USING btree (user_nationality_id);


--
-- TOC entry 2962 (class 1259 OID 27675)
-- Name: role_name; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX role_name ON public.user_roles USING btree (role_name);


--
-- TOC entry 2940 (class 1259 OID 27701)
-- Name: teams_code; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX teams_code ON public.lessons USING btree (lesson_teams_code);


--
-- TOC entry 2943 (class 1259 OID 27678)
-- Name: userPhoto; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX "userPhoto" ON public.users USING btree (user_photo);


--
-- TOC entry 2957 (class 1259 OID 27674)
-- Name: user_id_admins; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX user_id_admins ON public.admins USING btree (user_id);


--
-- TOC entry 2934 (class 1259 OID 18778)
-- Name: user_id_students; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX user_id_students ON public.students USING btree (user_id);


--
-- TOC entry 2937 (class 1259 OID 18779)
-- Name: user_id_teacher; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX user_id_teacher ON public.teachers USING btree (user_id);


--
-- TOC entry 2983 (class 2606 OID 27727)
-- Name: exam_result fk40xhde72mgtafkehr2c1ld6mg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam_result
    ADD CONSTRAINT fk40xhde72mgtafkehr2c1ld6mg FOREIGN KEY (student_id) REFERENCES public.students(student_id);


--
-- TOC entry 2980 (class 2606 OID 27626)
-- Name: questions_students fk5x76vrq91aofakwk35j3ed0cd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.questions_students
    ADD CONSTRAINT fk5x76vrq91aofakwk35j3ed0cd FOREIGN KEY (question_id) REFERENCES public.questions(question_id);


--
-- TOC entry 2974 (class 2606 OID 27601)
-- Name: departments fk6xpnvjcfa3l9gnqqb3x8v28iv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departments
    ADD CONSTRAINT fk6xpnvjcfa3l9gnqqb3x8v28iv FOREIGN KEY (faculty_id) REFERENCES public.faculties(faculty_id);


--
-- TOC entry 2978 (class 2606 OID 27636)
-- Name: student_lesson_relationship fk8pknbs54tkj4uqkq1nn98n1kq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_lesson_relationship
    ADD CONSTRAINT fk8pknbs54tkj4uqkq1nn98n1kq FOREIGN KEY (lesson_id) REFERENCES public.lessons(lesson_id);


--
-- TOC entry 2979 (class 2606 OID 27641)
-- Name: student_lesson_relationship fk95uhj2805hq49ytp8byio9sk5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student_lesson_relationship
    ADD CONSTRAINT fk95uhj2805hq49ytp8byio9sk5 FOREIGN KEY (student_id) REFERENCES public.students(student_id);


--
-- TOC entry 2968 (class 2606 OID 27691)
-- Name: students fkalgc33nsolpmegw14o3h6g6rr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.students
    ADD CONSTRAINT fkalgc33nsolpmegw14o3h6g6rr FOREIGN KEY (department_id) REFERENCES public.departments(department_id);


--
-- TOC entry 2969 (class 2606 OID 27651)
-- Name: teachers fkb8dct7w2j1vl1r2bpstw5isc0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT fkb8dct7w2j1vl1r2bpstw5isc0 FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- TOC entry 2972 (class 2606 OID 27616)
-- Name: lessons fkbr76cuebuufbbltujpfq04tto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT fkbr76cuebuufbbltujpfq04tto FOREIGN KEY (teacher_id) REFERENCES public.teachers(teacher_id);


--
-- TOC entry 2967 (class 2606 OID 27646)
-- Name: students fkdt1cjx5ve5bdabmuuf3ibrwaq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.students
    ADD CONSTRAINT fkdt1cjx5ve5bdabmuuf3ibrwaq FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- TOC entry 2977 (class 2606 OID 27596)
-- Name: admins fkgc8dtql9mkq268detxiox7fpm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admins
    ADD CONSTRAINT fkgc8dtql9mkq268detxiox7fpm FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- TOC entry 2973 (class 2606 OID 27656)
-- Name: users fkh555fyoyldpyaltlb7jva35j2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fkh555fyoyldpyaltlb7jva35j2 FOREIGN KEY (role_id) REFERENCES public.user_roles(role_id);


--
-- TOC entry 2982 (class 2606 OID 27722)
-- Name: exam_result fki8qa495036o7ne0q9ldb5ne11; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam_result
    ADD CONSTRAINT fki8qa495036o7ne0q9ldb5ne11 FOREIGN KEY (exam_id) REFERENCES public.exams(exam_id);


--
-- TOC entry 2971 (class 2606 OID 27611)
-- Name: lessons fkj48g1ixoig26ta2fe222m370x; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT fkj48g1ixoig26ta2fe222m370x FOREIGN KEY (department_id) REFERENCES public.departments(department_id);


--
-- TOC entry 2975 (class 2606 OID 27606)
-- Name: exams fkl8cqdyqs24nfu8rj7elugh6nc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exams
    ADD CONSTRAINT fkl8cqdyqs24nfu8rj7elugh6nc FOREIGN KEY (lesson_id) REFERENCES public.lessons(lesson_id);


--
-- TOC entry 2981 (class 2606 OID 27631)
-- Name: questions_students fkpa5iwsqx43rrpleo3vmi1v176; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.questions_students
    ADD CONSTRAINT fkpa5iwsqx43rrpleo3vmi1v176 FOREIGN KEY (student_id) REFERENCES public.students(student_id);


--
-- TOC entry 2970 (class 2606 OID 27696)
-- Name: teachers fkrgr03njnvpwuktc0mntf8t6o0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teachers
    ADD CONSTRAINT fkrgr03njnvpwuktc0mntf8t6o0 FOREIGN KEY (department_id) REFERENCES public.departments(department_id);


--
-- TOC entry 2976 (class 2606 OID 27621)
-- Name: questions fkrk78bmt53fns7np8casqa3q44; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.questions
    ADD CONSTRAINT fkrk78bmt53fns7np8casqa3q44 FOREIGN KEY (exam_id) REFERENCES public.exams(exam_id);


-- Completed on 2021-12-29 10:51:46

--
-- PostgreSQL database dump complete
--

