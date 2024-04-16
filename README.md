**I'll create a better read.me in the future.**

Database Structure:

Schema |       Name       | Type  | \
--------+------------------+-------+---------- \
public | categories       | table |\
public | products         | table |\
public | purchase_tickets | table | 

-------------+------------------------+-----------+----------+-----------------------------------------------------------+------------------------+---

                                      Table "public.categories"
Column    |          Type          | Collation | Nullable |                Default\
-------------+------------------------+-----------+----------+----------------------------------------\
id          | bigint                 |           | not null | nextval('categories_id_seq'::regclass)\
description | character varying(255) |           |          |\
name        | character varying(255) |           |          |\
Indexes:\
"categories_pkey" PRIMARY KEY, btree (id)\
Referenced by:\
TABLE "products" CONSTRAINT "fkog2rp4qthbtt2lfyhfo32lsw9" FOREIGN KEY (category_id) REFERENCES categories(id)

--------+------------------+-------+-----------------------+------------------------+-----------+----------+-----------------------------------------

                                      Table "public.purchase_tickets"
Column    |          Type          | Collation | Nullable |                   Default\
-------------+------------------------+-----------+----------+----------------------------------------------\
id          | bigint                 |           | not null | nextval('purchase_tickets_id_seq'::regclass)\
description | character varying(255) |           |          |\
items       | integer                |           |          |\
Indexes:\
"purchase_tickets_pkey" PRIMARY KEY, btree (id)


-------------+------------------------+-----------+----------+---------------------------------------------------------+------------------------+-----

                                      Table "public.products"
Column    |          Type          | Collation | Nullable |               Default\
-------------+------------------------+-----------+----------+--------------------------------------\
id          | bigint                 |           | not null | nextval('products_id_seq'::regclass)\
name        | character varying(255) |           |          |\
price       | double precision       |           |          |\
quantity    | integer                |           |          |\
category_id | bigint                 |           |          |

Indexes:\
"products_pkey" PRIMARY KEY, btree (id)\
Foreign-key constraints:\
"fkog2rp4qthbtt2lfyhfo32lsw9" FOREIGN KEY (category_id) REFERENCES categories(id)
