
CREATE TABLE utilisateur (
    id bigint DEFAULT nextval('utilisateurid_seq'::regclass) NOT NULL,
    groupeid integer NOT NULL,
    nomutilisateur text DEFAULT ''::text,
    codeutilisateur integer DEFAULT 0,
    login text DEFAULT ''::text,
    motdepasse text DEFAULT ''::text,
    imageutilisateur bytea DEFAULT ''::bytea,
    estverrouille boolean DEFAULT false,
    estconnecte boolean DEFAULT false,
    datesuppression timestamp without time zone,
    fk_contact bigint,
    fk_categorieprofilutilisateur bigint,
    datemodification timestamp without time zone,
    refid bigint
);

ALTER TABLE public.utilisateur OWNER TO tassyir;

CREATE TABLE droitsutilisateur (
    id bigint DEFAULT nextval('droitsutilisateurid_seq'::regclass) NOT NULL,
    groupeid integer NOT NULL,
    typefonction integer DEFAULT 0,
    autorise boolean DEFAULT false
);


ALTER TABLE public.droitsutilisateur OWNER TO tassyir;



CREATE TABLE contact (
    id bigint DEFAULT nextval('contactid_seq'::regclass) NOT NULL,
    groupeid integer NOT NULL,
    typecontact integer DEFAULT 0,
    nomcontact text DEFAULT ''::text,
    nomsocietecontact text DEFAULT ''::text,
    titrecontact text DEFAULT ''::text,
    adressecontact1 text DEFAULT ''::text,
    adressecontact2 text DEFAULT ''::text,
    alertesurtelephone1 boolean DEFAULT false,
    alertesurtelephone2 boolean DEFAULT false,
    codepostalcontact integer DEFAULT 0,
    estcontactprincipal boolean DEFAULT false,
    villecontact text DEFAULT ''::text,
    adressemailcontact text DEFAULT ''::text,
    faxcontact text DEFAULT ''::text,
    sitewebcontact text DEFAULT ''::text,
    telephonecontact1 text DEFAULT ''::text,
    telephonecontact2 text DEFAULT ''::text,
    estsupprimable boolean DEFAULT false,
    datesuppression timestamp without time zone,
    fk_groupecontact bigint,
    fk_fabriquant bigint,
    fk_fournisseur bigint
);


ALTER TABLE public.contact OWNER TO tassyir;


CREATE TABLE categorieprofilutilisateur (
    id bigint DEFAULT nextval('categorieprofilutilisateurid_seq'::regclass) NOT NULL,
    groupeid integer NOT NULL,
    libellecategorieprofilutilisateur text DEFAULT ''::text,
    estsupprimable boolean DEFAULT false,
    datesuppression timestamp without time zone
);

ALTER TABLE public.categorieprofilutilisateur OWNER TO tassyir;

CREATE TABLE fonction (
    id bigint DEFAULT nextval('fonctionid_seq'::regclass) NOT NULL,
    groupeid integer NOT NULL,
    typefonction integer DEFAULT 0,
    libellefonction text DEFAULT ''::text,
    estassociableparraccourci boolean DEFAULT false
);

ALTER TABLE public.fonction OWNER TO tassyir;

CREATE TABLE session (
    id bigint DEFAULT nextval('sessionid_seq'::regclass) NOT NULL,
    groupeid integer NOT NULL,
    debutsession timestamp without time zone,
    finsession timestamp without time zone,
    etatsession integer DEFAULT 0,
    typesession integer DEFAULT 0,
    montantfondsdecaisse bigint DEFAULT 0,
    utilisateurcourant integer DEFAULT 0,
    fk_caisse bigint,
    ref text DEFAULT ''::text,
    datecomptage timestamp without time zone
);
ALTER TABLE public.session OWNER TO tassyir;
