create table public.users(
	id int generated by default as identity  (increment 1 start 1 maxvalue 214783647 cache 1),
	email character varying(320) not null,
	password character varying(25) not null,
	constraint pk_users primary key(id),
	constraint uc_users_email unique(email)
);

create table public.employees(
	id int not null,
	first_name character varying(35) not null,
	last_name character varying(35) not null,
	constraint pk_employess primary key(id),
	constraint fk_employess_users foreign key(id) references public.users(id)
);
create table public.candidates(
	id int not null,
	first_name character varying(35) not null,
	last_name character varying(35) not null,
	identity_number character varying(11) not null,
	birth_year int not null,
	constraint pk_candidates primary key(id),
	constraint fk_candidates_users foreign key(id) references public.users(id),
	constraint uc_candidates_identity_number unique(identity_number)
);
create table public.employers(
	id int not null,
	company_name character varying(255) not null,
	web_address character varying(50) not null,
	phone_number character varying(12) not null,
	constraint pk_employers primary key(id),
	constraint fk_employers_users foreign key(id) references public.users(id)
);
create table public.verification_codes(
	id int generated by default as identity  (increment 1 start 1 maxvalue 214783647 cache 1),
	code character varying(38) not null,
	is_verificated boolean not null,
	verified_date date,
	constraint pk_verification_codes primary key(id),
	constraint uc_verification_codes_code unique(code)
);
create table public.verification_code_candidates(
	id int not null,
	candidate_id int not null,
	constraint pk_verification_code_candidates primary key(id),
	constraint fk_verification_code_candidates_verification_codes foreign key(id) references public.verification_codes(id),
	constraint fk_verification_code_candidates_candidates foreign key(candidate_id) references public.candidates(id)
);
create table public.verification_code_employers(
	id int not null,
	employer_id int not null,
	constraint pk_verification_code_employers primary key(id),
	constraint fk_verification_code_employers_verification_codes foreign key(id) references public.verification_codes(id),
	constraint fk_verification_code_employers_employers foreign key(employer_id) references public.employers(id)
	
);
create table public.employee_confirms(
	id int generated by default as identity  (increment 1 start 1 maxvalue 214783647 cache 1),
	employee_id int not null,
	is_confirmed boolean not null,
	confirms_date date,
	constraint pk_employee_confirms primary key(id),
	constraint fk_employee_confirms_employers foreign key(employee_id) references public.employees(id)
);
create table public.employee_confirm_employers(
	id int not null,
	employer_id int not null,
	constraint pk_employee_confirm_employers primary key(id),
	constraint fk_employee_confirm_employers_employee_confirms foreign key(id) references public.employee_confirms(id),
	constraint fk_employee_confirms_employers_employers foreign key(employer_id) references public.employers(id)
);
create table public.job_titles(
	id int generated by default as identity  (increment 1 start 1 maxvalue 214783647 cache 1),
	title character varying(255) not null,
	constraint pk_job_titles primary key(id),
	constraint uc_job_titles_title unique(title)
);