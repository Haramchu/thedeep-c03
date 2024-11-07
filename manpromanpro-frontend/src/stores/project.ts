import { defineStore } from 'pinia'
import type { ProjectInterface, ProjectRequestInterface } from '@/interfaces/project.interface'
import type { CommonResponseInterface } from '@/interfaces/common.interface'
import { useToast } from 'vue-toastification'
import router from '@/router'

export const useProjectStore = defineStore('project', {
    state: () => ({
        projects: [] as ProjectInterface[],
        loading: false,
        error: null as null | string,
    }),
    actions: {
        async getProjects() {
            this.loading = true
            this.error = null

            try {
                const response = await fetch('http://localhost:8080/api/proyek/viewall')
                const data: CommonResponseInterface<ProjectInterface[]> = await response.json()
                this.projects = data.data
            } catch (err) {
                this.error = `Gagal mengambil proyek ${err}`
            } finally {
                this.loading = false
            }
        },
        async addProject(body: ProjectRequestInterface) {
            this.loading = true
            this.error = null

            try {
                const response = await fetch('http://localhost:8080/api/proyek/add', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(body),
                });
                const data: CommonResponseInterface<ProjectInterface> = await response.json()
                this.projects.push(data.data)

                useToast().success('Sukses menambahkan proyek')
                await router.push('/proyek')
            } catch (err) {
                this.error = `Gagal menambah proyek ${(err as Error).message}`
                useToast().error(this.error)
            } finally {
                this.loading = false
            }
        },
        async updateProject(id: string, body: ProjectRequestInterface) {
            this.loading = true;
            this.error = null;

            try {
                const response = await fetch(
                    `http://localhost:8080/api/proyek/${id}/update`,
                    {
                        method: 'PUT',
                        headers: { 'Content-Type': 'application/json' },
                        body: JSON.stringify({ id, ...body }),
                    }
                );
                const data: CommonResponseInterface<ProjectInterface> = await response.json();
                this.projects.push(data.data);

                useToast().success("Sukses mengubah proyek");
                await router.push("/proyek");
            } catch (err) {
                this.error = `Gagal mengubah proyek ${(err as Error).message}`;
                useToast().error(this.error);
            } finally {
                this.loading = false;
            }
        },
        async getProjectDetail(id: string): Promise<ProjectInterface | undefined> {
            this.loading = true;
            this.error = null;

            try {
                const response = await fetch(`http://localhost:8080/api/proyek/${id}`);
                const data: CommonResponseInterface<ProjectInterface> = await response.json();
                return data.data;
            } catch (err) {
                this.error = `Gagal mengambil proyek ${err}`;
            } finally {
                this.loading = false;
            }
        }
    },
})