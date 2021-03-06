PGDMP         8                z        	   Telefonia    14.1    14.1                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    57626 	   Telefonia    DATABASE     g   CREATE DATABASE "Telefonia" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE "Telefonia";
                postgres    false            ?            1259    57682    chiamata    TABLE       CREATE TABLE public.chiamata (
    cod_chiamata integer NOT NULL,
    cod_linea_chiamante integer NOT NULL,
    data_inizio timestamp with time zone NOT NULL,
    data_fine timestamp with time zone NOT NULL,
    durata bigint NOT NULL,
    cod_linea_chiamato integer
);
    DROP TABLE public.chiamata;
       public         heap    postgres    false            ?            1259    57711    chiamata_cod_chiamata_seq    SEQUENCE     ?   ALTER TABLE public.chiamata ALTER COLUMN cod_chiamata ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.chiamata_cod_chiamata_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    213            ?            1259    57628    cliente    TABLE     ?   CREATE TABLE public.cliente (
    cod_cliente integer NOT NULL,
    nome character varying,
    cognome character varying,
    cf character varying NOT NULL,
    cod_linea integer NOT NULL
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            ?            1259    57627    cliente_cod_cliente_seq    SEQUENCE     ?   ALTER TABLE public.cliente ALTER COLUMN cod_cliente ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.cliente_cod_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210            ?            1259    57636    linea    TABLE     ?   CREATE TABLE public.linea (
    cod_linea integer NOT NULL,
    tipo character varying NOT NULL,
    stato character varying NOT NULL,
    telefono character varying
);
    DROP TABLE public.linea;
       public         heap    postgres    false            ?            1259    57635    linea_cod_linea_seq    SEQUENCE     ?   ALTER TABLE public.linea ALTER COLUMN cod_linea ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.linea_cod_linea_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    212            ?          0    57682    chiamata 
   TABLE DATA                 public          postgres    false    213   @       ?          0    57628    cliente 
   TABLE DATA                 public          postgres    false    210   ?       ?          0    57636    linea 
   TABLE DATA                 public          postgres    false    212   ?                  0    0    chiamata_cod_chiamata_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.chiamata_cod_chiamata_seq', 23, true);
          public          postgres    false    214                       0    0    cliente_cod_cliente_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.cliente_cod_cliente_seq', 3, true);
          public          postgres    false    209                       0    0    linea_cod_linea_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.linea_cod_linea_seq', 2, true);
          public          postgres    false    211            k           2606    57686    chiamata chiamata_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.chiamata
    ADD CONSTRAINT chiamata_pkey PRIMARY KEY (cod_chiamata);
 @   ALTER TABLE ONLY public.chiamata DROP CONSTRAINT chiamata_pkey;
       public            postgres    false    213            g           2606    57634    cliente cliente_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cod_cliente);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    210            i           2606    57693    linea linea_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.linea
    ADD CONSTRAINT linea_pkey PRIMARY KEY (cod_linea);
 :   ALTER TABLE ONLY public.linea DROP CONSTRAINT linea_pkey;
       public            postgres    false    212            l           2606    57699    cliente cod_linea    FK CONSTRAINT     ?   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cod_linea FOREIGN KEY (cod_linea) REFERENCES public.linea(cod_linea) NOT VALID;
 ;   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cod_linea;
       public          postgres    false    3177    210    212            m           2606    57706    chiamata cod_linea_chiamante    FK CONSTRAINT     ?   ALTER TABLE ONLY public.chiamata
    ADD CONSTRAINT cod_linea_chiamante FOREIGN KEY (cod_linea_chiamante) REFERENCES public.linea(cod_linea) NOT VALID;
 F   ALTER TABLE ONLY public.chiamata DROP CONSTRAINT cod_linea_chiamante;
       public          postgres    false    212    3177    213            n           2606    57712    chiamata cod_linea_chiamato    FK CONSTRAINT     ?   ALTER TABLE ONLY public.chiamata
    ADD CONSTRAINT cod_linea_chiamato FOREIGN KEY (cod_linea_chiamato) REFERENCES public.linea(cod_linea) NOT VALID;
 E   ALTER TABLE ONLY public.chiamata DROP CONSTRAINT cod_linea_chiamato;
       public          postgres    false    212    3177    213            ?   ?   x???v
Q???W((M??L?K??L?M,IT?H?O???t@??̼?D?X^I??B
P*>3/?*3?I*2K??j*??T?s
?t??sW?q?Us?	u???
F?:
F:
?FFF????
?FV?V?F??2?pcCMk... ??>?      ?   ?   x??α
?0?=O?o*H;v*4?@???B'I??I???5????n?c\R??q??g}:?t???@?ar???)%?w?k+???7????B??W??h??v?{J(?5?"?"A?8??8{tIMu"??O????????OZ????/)?S?      ?   ?   x???v
Q???W((M??L????KMT?H?O?3uJ2?u?KK?TIjNjZ~^????kP??????Bpdp???B??O?+?V?0?QP??O??IU?R2?KJ2?KA\cK##K#S3sCuMk.O:??7?\`ddhlhr v?Om     