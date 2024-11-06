import { defineStore } from 'pinia'
import type { ProjectInterface } from '@/interfaces/project.interface'
import type { CommonResponseInterface } from '@/interfaces/common.interface'

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
        }
    },
})