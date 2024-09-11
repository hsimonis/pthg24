all: fdp.pdf

fdp.pdf: coauth.gv
	fdp -Tpdf coauth.gv >fdp.pdf
	
clean:
	rm -f fdp.pdf
	